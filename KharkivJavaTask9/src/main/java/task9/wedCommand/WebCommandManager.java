package task9.wedCommand;

import com.epam.poliak.service.TransportService;

import java.util.HashMap;
import java.util.Map;

public class WebCommandManager {

    private Map<String, WebCommand> commandMap = new HashMap<>();
    private TransportService transportService;

    public WebCommandManager(TransportService transportService) {
        this.transportService = transportService;
        fillMap();
    }

    public WebCommand getCommand(String key) {
        return commandMap.get(key);
    }

    private void fillMap() {
        commandMap.put("get count", new GetCountOfTransport(transportService));
        commandMap.put("get transport", new GetTransportName(transportService));
    }

}
