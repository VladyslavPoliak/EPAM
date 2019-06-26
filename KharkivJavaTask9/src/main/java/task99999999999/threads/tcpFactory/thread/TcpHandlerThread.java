package task99999999999.threads.tcpFactory.thread;

import com.epam.poliak.service.TransportService;
import task99999999999.container.WebCommandManager;
import task99999999999.server.AbstractCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class TcpHandlerThread extends Thread {

    private Socket socket;
    private Map<String, AbstractCommand> commandMap;

    public TcpHandlerThread(Socket socket, TransportService transportService) {
        this.socket = socket;
        commandMap = new WebCommandManager(transportService).initWebCommandMap();
    }

    @Override
    public void run() {
        try {
            processRequest();
        } catch (IOException e) {
            System.out.println("Something is wrong");
        }
    }

    private void processRequest() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        String request = reader.readLine();
        writer.println(commandMap.get(getCommandFromRequest(request)).doCommand(getParametersFromRequest(request)));
    }

    private String getCommandFromRequest(String request) {
        String[] splitRequest = request.split("=");
        return splitRequest[0];
    }

    private String getParametersFromRequest(String request) {
        String[] splitRequest = request.split("=");
        if (splitRequest.length > 1) {
            return splitRequest[1];
        }
        return null;
    }
}
