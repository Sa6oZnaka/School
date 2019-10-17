import com.company.Client;
import com.company.Server;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Tests{

    private static Server server;

    @Before
    public void init(){
        new Thread(){
            public void run(){
                server = new Server();
                try {
                    server.start(4444);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Test
    public void connectDisconnectTest() throws IOException {
        Client client = new Client();
        client.startConnection("localhost", 4444);
        assertEquals("---client1 connected---", client.readLine());
        client.sendMessage("exit");
        assertEquals("bye", client.readLine());
    }

    @Test
    public void sendMessageTest() throws IOException {
        Client client = new Client();
        client.startConnection("localhost", 4444);

        Client client2 = new Client();
        client2.startConnection("localhost", 4444);

        client.sendMessage("all Hello!");

        assertEquals("Hello!", client2.readLine());
        client.sendMessage("exit");
        assertEquals("bye", client.readLine());
        client2.sendMessage("exit");
    }



}