package task9.wedCommand;

import com.epam.poliak.service.TransportService;
import task9.wedCommand.impl.GetCountOfTransport;
import task9.wedCommand.impl.GetTransportName;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WebCommandManager {

    private Map<String, WebCommand> commandMap = new HashMap<>();
    private TransportService transportService;

    public WebCommandManager(TransportService transportService) {
        this.transportService = transportService;
        fillMap();
    }

    public WebCommand getCommand(String key) {
        System.out.println(key);
        System.out.println(commandMap.containsKey(key));
        return commandMap.get(key);
    }

    private void fillMap() {
        commandMap.put(".+get count.+", new GetCountOfTransport(transportService));
        commandMap.put(".+get transport.+", new GetTransportName(transportService));
        commandMap.put("^GET /shop/count HTTP/1\\.1$", new GetCountOfTransport(transportService));
        commandMap.put(".+/item\\?get_info=.+", new GetTransportName(transportService));
    }

    public WebCommand processRequest(String key) {
        Optional<String> optional = commandMap.keySet().stream()
                .filter(key::matches)
                .findFirst();
        return commandMap.get(optional.orElse(null));
    }
}
