package task9.wedCommand.impl;

import com.epam.poliak.service.TransportService;
import task9.wedCommand.WebCommand;

import java.io.PrintWriter;

public class GetCountOfTransport implements WebCommand {

    private TransportService transportService;

    public GetCountOfTransport(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public void doCommand(String request, Object serverType, PrintWriter out) {
        out.println(transportService.getAllTransport().size());
    }
}
