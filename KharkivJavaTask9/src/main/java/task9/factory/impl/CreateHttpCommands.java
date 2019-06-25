package task9.factory.impl;

import com.epam.poliak.service.TransportService;
import task9.RunCommand;
import task9.factory.Factory;
import task9.server.http.impl.GetCountHttp;
import task9.server.http.impl.GetNameHttp;

public class CreateHttpCommands extends Factory {

    public CreateHttpCommands(TransportService transportService) {
        super(transportService);
    }

    @Override
    public RunCommand getName() {
        return new GetNameHttp(transportService);
    }

    @Override
    public RunCommand getCount() {
        return new GetCountHttp(transportService);
    }
}
