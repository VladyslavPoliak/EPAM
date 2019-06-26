package task99999999999.server.tcp;

import com.epam.poliak.service.TransportService;
import task99999999999.server.AbstractCommand;

public class GetCountTcp extends AbstractCommand {

    public GetCountTcp(TransportService transportService) {
        super(transportService);
    }

    @Override
    public String doCommand(String request) {
        return String.valueOf(transportService.getAllTransport().size());
    }
}
