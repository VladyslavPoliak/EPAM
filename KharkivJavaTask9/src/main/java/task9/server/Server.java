package task9.server;


import task9.wedCommand.WebCommandManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {

    private Socket socket;
    private WebCommandManager commandManager;
    private String command;
    private String parameter;

    public Server(Socket socket, WebCommandManager commandManager) {
        this.socket = socket;
        this.commandManager = commandManager;
    }

    @Override
    public void run() {
        try (Scanner reader = new Scanner(socket.getInputStream());
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String request;
            while (!(request = reader.nextLine()).equals("exit")) {
                System.out.println("Client: " + request);
                processRequest(request);
                out.println(commandManager.getCommand(command).doCommand(parameter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(String request) {
        String[] splitRequest = request.split("=");
        command = splitRequest[0];
        if (splitRequest.length > 1) {
            parameter = splitRequest[1];
        }
    }


}
