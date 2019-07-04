package task9.threads.tcpFactory;

import com.epam.poliak.service.TransportService;
import task9.threads.AbstractFactory;
import task9.threads.tcpFactory.thread.TcpHandlerThread;

import java.net.Socket;

public class TcpFactory extends AbstractFactory {

    @Override
    public Thread createHandleThread(Socket socket, TransportService transportService) {
        return new TcpHandlerThread(socket, transportService);
    }
}
