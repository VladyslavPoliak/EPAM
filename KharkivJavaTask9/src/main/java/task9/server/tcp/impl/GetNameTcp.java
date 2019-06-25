package task9.server.tcp.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;
import task9.server.tcp.AbstractTcp;

public class GetNameTcp extends AbstractTcp {

    public GetNameTcp(TransportService transportService) {
        super(transportService);
    }

    @Override
    public String doCommand(String request) {
        Transport transport = transportService.getTransportByID(Integer.parseInt(request));
        return transport.getProducer() + "|" + transport.getPrice();
    }
}
