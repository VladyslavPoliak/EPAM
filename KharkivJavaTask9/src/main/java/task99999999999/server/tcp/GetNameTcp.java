package task99999999999.server.tcp;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;
import task99999999999.server.AbstractCommand;

public class GetNameTcp extends AbstractCommand {

    public GetNameTcp(TransportService transportService) {
        super(transportService);
    }

    @Override
    public String doCommand(String request) {
        Transport transport = transportService.getTransportByID(Integer.parseInt(request));
        return transport.getProducer() + "|" + transport.getPrice();
    }
}
