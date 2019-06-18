package task9.wedCommand;

import com.epam.poliak.service.TransportService;

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
