package task9.factory.impl;

import com.epam.poliak.service.TransportService;
import task9.RunCommand;
import task9.factory.Factory;
import task9.server.tcp.impl.GetCountTcp;
import task9.server.tcp.impl.GetNameTcp;

public class CreateTcpCommands extends Factory {


    public CreateTcpCommands(TransportService transportService) {
        super(transportService);
    }

    @Override
    public RunCommand getName() {
        return new GetNameTcp(transportService);
    }

    @Override
    public RunCommand getCount() {
        return new GetCountTcp(transportService);
    }
}
