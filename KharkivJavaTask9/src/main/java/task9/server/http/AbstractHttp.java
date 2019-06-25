package task9.server.http;

import com.epam.poliak.service.TransportService;
import task9.RunCommand;

public abstract class AbstractHttp implements RunCommand {

    protected TransportService transportService;

    public AbstractHttp(TransportService transportService) {
        this.transportService = transportService;
    }
}
