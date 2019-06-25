package task9.server.tcp;


import com.epam.poliak.utils.Constants;
import task9.WebCommandManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements Runnable {

    private WebCommandManager commandManager;
    private String command;
    private String parameter;

    public TCPServer(WebCommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(Constants.PORT_FOR_TCP);
            while (true) {
                Socket socket = serverSocket.accept();
                socket.setTcpNoDelay(true);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                String request = br.readLine();
                System.out.println("Client: " + request);
                setParametersFromRequest(request);
                printWriter.println(commandManager.getCommandFromMap(command).doCommand(parameter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setParametersFromRequest(String request) {
        String[] splitRequest = request.split("=");
        command = splitRequest[0];
        if (splitRequest.length > 1) {
            parameter = splitRequest[1];
        }
    }
}
