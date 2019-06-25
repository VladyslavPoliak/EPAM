package task9.server.tcp.command;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;
import task9.server.AbstractServer;

public class GetNameTcp extends AbstractServer {

    public GetNameTcp(TransportService transportService) {
        super(transportService);
    }

    @Override
    public String doCommand(String request) {
        Transport transport = transportService.getTransportByID(Integer.parseInt(request));
        return transport.getProducer() + "|" + transport.getPrice();
    }
}
