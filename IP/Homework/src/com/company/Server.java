package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Server {

    private ServerSocket serverSocket;
    List<EchoClientHandler> handlers = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server();
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        System.out.println("Server started at 127.0.0.1:" + port);
        server.start(Integer.parseInt(port));
    }

    private void start(int port) throws IOException, InterruptedException {
        serverSocket = new ServerSocket(port);
        int clientsConnected = 0;
        while (clientsConnected < 1000) {
            System.out.println("client" + clientsConnected + " connected!");
            var clientSocket = serverSocket.accept();
            var handler = new EchoClientHandler(clientSocket, clientsConnected);
            handler.start();
            handlers.add(handler);
            clientsConnected++;
        }

        for (EchoClientHandler handler : handlers) {
            handler.join();
            System.out.println("join called!");
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }

    public void processMessage(String sender, String msg){

        ArrayList<String> commands = (ArrayList<String>) Arrays.asList(msg.split(" "));

        String type = commands.get(0);
        commands.remove(commands.get(0));
        String receiver = null;
        if(! type.equals("all")) {
            receiver = commands.get(1);
            commands.remove(commands.get(1));
        }

        String message = String.join(" ", commands);
        String output = "[client" + sender + "]" + message;

        //System.out.println(output); // print in the server
        if(type.equals("all")) {
            for (EchoClientHandler handler : handlers) {
                handler.out.println(output); // send to all clients
            }
        }else {
            for (EchoClientHandler handler : handlers) {
                Integer s = handler.index;
                if(handler.name.equals(receiver)) {
                    handler.out.println(output); // send to specific client
                }
            }
        }
    }

    private static class EchoClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private int index;
        private String name;

        EchoClientHandler(Socket socket, int index) {
            this.clientSocket = socket;
            this.index = index;

            this.name = "client" + index;
        }

        public void run() {
            try {

                out = new PrintWriter(clientSocket.getOutputStream(), true);

                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if ("exit".equals(inputLine)) {
                        out.println("bye");
                        break;
                    }
                    System.out.println("[" + name + "] " + inputLine);
                    out.println("[" + name + "] " + inputLine);
                    // send text to the server
                    // TODO
                    // Server.processMessage(name, inputLine);
                    /////
                }

                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}