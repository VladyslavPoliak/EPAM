package test9.forTcp;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;
import test9.Tcp;

public class TcpCommands implements Tcp {

    private TransportService transportService;

    public TcpCommands(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public String getCount() {
        return String.valueOf(transportService.getAllTransport().size());
    }

    @Override
    public String getName(String request) {
        Transport transport = transportService.getTransportByID(Integer.parseInt(request));
        return transport.getProducer() + "|" + transport.getPrice();

    }
}
