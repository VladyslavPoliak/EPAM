package task9.server.http.impl;

import com.epam.poliak.service.TransportService;
import org.json.JSONObject;
import task9.server.http.AbstractHttp;

public class GetCountHttp extends AbstractHttp {

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
