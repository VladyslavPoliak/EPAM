package task9.client;

import com.epam.poliak.utils.Constants;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public static void main(String[] args) {
        Client client = new Client(Constants.HOST, Constants.PORT);
        client.connectToServer();
    }

    private void connectToServer() {
        try (Socket socket = new Socket(host, port);
             Scanner server = new Scanner(socket.getInputStream());
             Scanner console = new Scanner(System.in);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println(Constants.CLIENT_MENU);
            String request ;
            while (!(request = console.nextLine()).equals("exit")) {
                out.println(request);
                System.out.println("Response: " + server.next());
            }
        } catch (IOException e) {
            System.out.println(Constants.CONNECT_ERROR);
        }
    }
}
