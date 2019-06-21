package task9.wedCommand.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;
import org.json.JSONObject;
import task9.server.HttpServer;
import task9.wedCommand.WebCommand;

import java.io.PrintWriter;

public class GetTransportName implements WebCommand {

    private TransportService transportService;

    public GetTransportName(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public void doCommand(String request, Object serverType, PrintWriter out) {
        Transport transport = transportService.getTransportByID(Integer.parseInt(request));
        if (serverType instanceof HttpServer) {
            out.println(getResponseForHttp(transport, out));
            return;
        }
        out.println(transport.getProducer() + "|" + transport.getPrice());
    }

    private String getResponseForHttp(Transport transport, PrintWriter out) {
        out.println(Constants.HTTP_CODE_200);
        out.println();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Producer", transport.getProducer());
        jsonObject.put("Price", transport.getPrice());
        return jsonObject.toString();
    }
}
