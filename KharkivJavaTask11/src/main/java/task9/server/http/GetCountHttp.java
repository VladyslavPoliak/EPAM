package task9.server.http;

import com.epam.poliak.service.TransportService;
import org.json.JSONObject;
import task9.server.AbstractCommand;

public class GetCountHttp extends AbstractCommand {

    public GetCountHttp(TransportService transportService) {
        super(transportService);
    }

    @Override
    public String doCommand(String request) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", transportService.getCountOfTransport());
        return jsonObject.toString();
    }
}
