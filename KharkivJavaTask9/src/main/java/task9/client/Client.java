package task9.client;

import com.epam.poliak.utils.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        Client client = new Client(Constants.HOST, Constants.PORT_FOR_TCP);
        client.connectToServer();
    }

    private void connectToServer() {
        try {
            String request;
            while (true) {
                Socket socket = new Socket(host, port);
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                Scanner console = new Scanner(System.in);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                System.out.println(Constants.CLIENT_MENU);
                request = console.nextLine();
                out.println(request);
                System.out.println("Response from server: " + br.readLine() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(Constants.CONNECT_ERROR);
        }
    }
}
