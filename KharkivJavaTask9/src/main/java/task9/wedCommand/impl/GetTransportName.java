package task9.wedCommand.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;
import task9.wedCommand.WebCommand;

public class GetTransportName implements WebCommand {

    private TransportService transportService;

    public GetTransportName(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public String doCommand(String request) {
        Transport transport = transportService.getTransportByID(Integer.parseInt(request));
        return transport.getProducer() + "|" + transport.getPrice();
    }
}
