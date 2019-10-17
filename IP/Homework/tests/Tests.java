import com.company.Client;
import com.company.Server;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests{

    private static Server server;
    private static Integer port;
    private static Client cli1;

    @BeforeAll
    public static void init(){
        port = 25565;
        new Thread(){
            public void run(){
                server = new Server();
                try {
                    server.start(port);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Order(1)
    @Test
    public void connectDisconnectTest() throws IOException {
        Client client = new Client();
        client.startConnection("localhost", port);
        assertEquals("---client1 connected---", client.readLine());
        client.sendMessage("exit");
        assertEquals("bye", client.readLine());
    }

    @Order(3)
    @Test
    public void sendMessageTest() throws IOException, InterruptedException {
        cli1 = new Client();
        cli1.startConnection("localhost", port);
        cli1.readLine();

        Client client2 = new Client();
        client2.startConnection("localhost", port);
        cli1.readLine();

        cli1.sendMessage("all Hello!");

        assertEquals("[client3] (all) Hello! ", cli1.readLine().toString());
        //cli1.sendMessage("exit");
        //assertEquals("bye", cli1.readLine());
        client2.sendMessage("exit");
    }

    @Order(4)
    @Test
    public void sendPrivateMessageTest() throws IOException, InterruptedException {
        Client client = new Client();
        client.startConnection("localhost", port);
        client.readLine();

        Client client2 = new Client();
        client2.startConnection("localhost", port);
        client.readLine();

        client.sendMessage("private client6 Hello!");

        assertEquals("[client5] (private) Hello! ", client.readLine().toString());
        client.sendMessage("exit");
        assertEquals("bye", client.readLine());
        client2.sendMessage("exit");
    }

    @Order(6)
    @Test
    public void connect100clients() throws IOException, InterruptedException, ConnectException, ConcurrentModificationException {
        List<Client> clients = new ArrayList<>();
        for(int i = 0; i < 100; i ++){
            Client c = new Client();
            clients.add(c);
        }
        assertEquals(clients.size(), 100);
    }

    @Order(2)
    @Test
    public void info() throws IOException, InterruptedException, ConnectException, ConcurrentModificationException {
        Client client = new Client();
        client.startConnection("localhost", port);
        client.readLine();

        client.sendMessage("info");

        assertEquals("[client2]", client.readLine());
        client.sendMessage("exit");
    }

    @Order(5)
    @Test
    public void changeName() throws IOException, InterruptedException, ConnectException, ConcurrentModificationException {
        cli1.sendMessage("name Gosho");
        cli1.sendMessage("info");

        cli1.readLine();
        cli1.readLine();
        cli1.readLine();
        cli1.readLine();
        cli1.readLine();
        assertEquals(cli1.readLine(), "[Gosho]");
    }

}