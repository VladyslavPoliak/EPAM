package task99999999999.server;

import com.epam.poliak.service.TransportService;
import task99999999999.container.WebCommandManager;
import task99999999999.threads.AbstractFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Server implements Runnable {

    private Map<Integer, AbstractFactory> factoryMap;
    private TransportService transportService;
    private ServerSocket serverSocket;

    public Server(TransportService transportService, ServerSocket serverSocket) {
        this.transportService = transportService;
        this.serverSocket = serverSocket;
        factoryMap = new WebCommandManager(transportService).initFactory();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                factoryMap.get(serverSocket.getLocalPort()).createHandleThread(socket, transportService).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
