package task9.server.tcp.command;

import com.epam.poliak.service.TransportService;
import task9.server.AbstractServer;

public class GetCountTcp extends AbstractServer {

    public GetCountTcp(TransportService transportService) {
        super(transportService);
    }

    @Override
    public String doCommand(String request) {
        return String.valueOf(transportService.getAllTransport().size());
    }
}
