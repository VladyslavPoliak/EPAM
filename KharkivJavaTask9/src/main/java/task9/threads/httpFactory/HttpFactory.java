package task9.threads.httpFactory;

import com.epam.poliak.service.TransportService;
import task9.threads.AbstractFactory;
import task9.threads.httpFactory.thread.HttpHandlerThread;

import java.net.Socket;

public class HttpFactory extends AbstractFactory {

    @Override
    public Thread createHandleThread(Socket socket, TransportService transportService) {
        return new HttpHandlerThread(socket, transportService);
    }
}
