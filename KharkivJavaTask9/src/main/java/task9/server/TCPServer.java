package task9.server;


import com.epam.poliak.utils.Constants;
import task9.wedCommand.RunCommandThread;
import task9.wedCommand.WebCommandManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
                String request = br.readLine();
                System.out.println("Client: " + request);
                setParametersFromRequest(request);
                new Thread(new RunCommandThread(commandManager.getCommandFromMap(command)
                        , socket, parameter, this)).start();
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
