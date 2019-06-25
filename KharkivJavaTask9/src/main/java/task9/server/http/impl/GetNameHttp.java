package task9.server.http.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;
import org.json.JSONObject;
import task9.server.http.AbstractHttp;

public class GetNameHttp extends AbstractHttp {

    public GetNameHttp(TransportService transportService) {
        super(transportService);
    }

    @Override
    public String doCommand(String request) {
        Transport transport = transportService.getTransportByID(Integer.parseInt(request));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Producer", transport.getProducer());
        jsonObject.put("Price", transport.getPrice());
        return jsonObject.toString();
    }
}
