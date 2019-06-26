package task99999999999.server;

import com.epam.poliak.service.TransportService;
import task99999999999.RunCommand;

public abstract class AbstractCommand implements RunCommand {

    protected TransportService transportService;

    public AbstractCommand(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public abstract String doCommand(String request);

}
