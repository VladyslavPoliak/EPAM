package task9.server.tcp.impl;

import com.epam.poliak.service.TransportService;
import task9.server.tcp.AbstractTcp;

public class GetCountTcp extends AbstractTcp {

    public GetCountTcp(TransportService transportService) {
        super(transportService);
    }

    @Override
    public String doCommand(String request) {
        return String.valueOf(transportService.getAllTransport().size());
    }
}
