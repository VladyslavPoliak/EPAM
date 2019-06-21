package task9.wedCommand.impl;

import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;
import org.json.JSONObject;
import task9.server.HttpServer;
import task9.wedCommand.WebCommand;

import java.io.PrintWriter;

public class GetCountOfTransport implements WebCommand {

    private TransportService transportService;

    public GetCountOfTransport(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public void doCommand(String request, Object serverType, PrintWriter out) {
        int size = transportService.getAllTransport().size();
        if (serverType instanceof HttpServer) {
            out.println(getResponseForHttp(size, out));
            return;
        }
        out.println(transportService.getAllTransport().size());
    }

    private String getResponseForHttp(int size, PrintWriter out) {
        out.println(Constants.HTTP_CODE_200);
        out.println();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count", size);
        return jsonObject.toString();
    }
}
