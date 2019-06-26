package task99999999999.threads.httpFactory;

import com.epam.poliak.service.TransportService;
import task99999999999.threads.AbstractFactory;
import task99999999999.threads.httpFactory.thread.HttpHandlerThread;

import java.net.Socket;

public class HttpFactory extends AbstractFactory {

    @Override
    public Thread createHandleThread(Socket socket, TransportService transportService) {
        return new HttpHandlerThread(socket, transportService);
    }
}
