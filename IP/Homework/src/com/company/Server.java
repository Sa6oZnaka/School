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

    static List<EchoClientHandler> handlers = new ArrayList<>();
    private ServerSocket serverSocket;

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

        void processMessage(String sender, String msg) {

            List<String> commands = Arrays.asList(msg.split(" "));
            int removed = 0;
            String type = commands.get(0);
            System.out.println(type);
            String receiver = null;
            switch (type) {
                case "all":
                    removed = 1;
                    break;
                case "private":
                    receiver = commands.get(1);
                    removed = 2;
                    break;
                case "name":
                    name = commands.get(1);
                    break;
                default:
                    out.println("--error---");
                    break;
            }
            if (type.equals("all") || type.equals("private")) {
                StringBuilder text = new StringBuilder();
                for (int i = removed; i < commands.size(); i++) {
                    text.append(commands.get(i)).append(" ");
                }
                String output = "[" + sender + "]" + " (" + type + ") " + String.join(" ", text);

                if (type.equals("all")) {
                    for (EchoClientHandler handler : handlers) {
                        handler.out.println(output); // send to all clients
                    }
                } else {
                    for (EchoClientHandler handler : handlers) {
                        Integer s = handler.index;
                        if (handler.name.equals(receiver)) {
                            handler.out.println(output); // send to specific client
                            out.println(output);
                        }
                    }
                }
            }
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
                    //System.out.println("[" + name + "] " + inputLine);
                    //out.println("[" + name + "] " + inputLine);
                    // send text to the server
                    // TODO
                    processMessage(name, inputLine);
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