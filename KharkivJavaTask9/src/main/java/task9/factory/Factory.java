package task9.factory;

import com.epam.poliak.service.TransportService;
import task9.RunCommand;

public abstract class Factory {

    protected TransportService transportService;

    public Factory(TransportService transportService) {
        this.transportService = transportService;
    }

    public abstract RunCommand getName();

    public abstract RunCommand getCount();


}
