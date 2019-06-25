package task9.server;

import com.epam.poliak.service.TransportService;
import task9.RunCommand;

public abstract class AbstractServer implements RunCommand {

    protected TransportService transportService;

    public AbstractServer(TransportService transportService) {
        this.transportService = transportService;
    }
}
