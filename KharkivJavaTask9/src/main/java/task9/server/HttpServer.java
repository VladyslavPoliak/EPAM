package task9.server;

import com.epam.poliak.utils.Constants;
import task9.wedCommand.RunCommandThread;
import task9.wedCommand.WebCommandManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpServer implements Runnable {

    private WebCommandManager commandManager;

    public HttpServer(WebCommandManager commandManager) {
        this.commandManager = commandManager;
    }


    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(Constants.PORT_FOR_HTTP);
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request;
                request = br.readLine();
                System.out.println("Client: " + request);
                new Thread(new RunCommandThread(commandManager.processRequest(request), socket,
                        String.valueOf(processRequest(request)))).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int processRequest(String request) {
        Matcher matcher = Pattern.compile(Constants.GET_ITEM_REQUEST_REGEXP).matcher(request);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }
}
