package task99999999999.server.http;

import com.epam.poliak.service.TransportService;
import org.json.JSONObject;
import task99999999999.server.AbstractCommand;

public class GetCountHttp extends AbstractCommand {

    public GetCountHttp(TransportService transportService) {
        super(transportService);
    }

    @Override
    public String doCommand(String request) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", transportService.getAllTransport().size());
        return jsonObject.toString();
    }
}
