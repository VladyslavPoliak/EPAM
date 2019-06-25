package task9.server.http;

import com.epam.poliak.utils.Constants;
import task9.WebCommandManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                OutputStream writer = socket.getOutputStream();
                startProcessRequest(reader.readLine(), writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startProcessRequest(String request, OutputStream writer) throws IOException {
        if (request.startsWith(Constants.START_REQUEST)) {
            writer.write(Constants.HTTP_CODE_200.getBytes());
            writer.write(Constants.SEPARATOR.getBytes());
            String s = commandManager.getCommandFromMap(request)
                    .doCommand(String.valueOf(getParametersFromRequest(request)));
            String result = Constants.RESPONSE_HEADER + s;
            writer.write(result.getBytes());
            writer.flush();
        } else {
            System.out.println("Wrong command");
        }
    }

    private int getParametersFromRequest(String request) {
        Matcher matcher = Pattern.compile(Constants.GET_ITEM_REQUEST_REGEXP).matcher(request);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }
}
