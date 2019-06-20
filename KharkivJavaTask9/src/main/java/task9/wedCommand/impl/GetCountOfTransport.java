package task9.wedCommand.impl;

import com.epam.poliak.service.TransportService;
import task9.wedCommand.WebCommand;

public class GetCountOfTransport implements WebCommand {

    private TransportService transportService;

    public GetCountOfTransport(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public String doCommand(String request) {
        return String.valueOf(transportService.getAllTransport().size());
    }
}
