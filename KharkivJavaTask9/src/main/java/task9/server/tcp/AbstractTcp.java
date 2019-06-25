package task9.server.tcp;

import com.epam.poliak.service.TransportService;
import task9.RunCommand;

public abstract class AbstractTcp implements RunCommand {

    protected TransportService transportService;

    public AbstractTcp(TransportService transportService) {
        this.transportService = transportService;
    }


}
