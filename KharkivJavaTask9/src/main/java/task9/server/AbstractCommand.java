package task9.server;

import com.epam.poliak.service.TransportService;
import task9.RunCommand;

public abstract class AbstractCommand implements RunCommand {

    protected TransportService transportService;

    public AbstractCommand(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public abstract String doCommand(String request);

}
