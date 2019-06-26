package task99999999999.threads;

import com.epam.poliak.service.TransportService;

import java.net.Socket;

public abstract class AbstractFactory {

    public abstract Thread createHandleThread(Socket socket, TransportService transportService);

}
