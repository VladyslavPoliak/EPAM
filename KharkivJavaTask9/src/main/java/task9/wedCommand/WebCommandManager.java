package task9.wedCommand;

import com.epam.poliak.service.TransportService;
import task9.wedCommand.impl.GetCountOfTransport;
import task9.wedCommand.impl.GetTransportName;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WebCommandManager {

    private Map<String, WebCommand> webCommandMap = new HashMap<>();
    private TransportService transportService;

    public WebCommandManager(TransportService transportService) {
        this.transportService = transportService;
        fillMap();
    }

    private void fillMap() {
        webCommandMap.put("get count", new GetCountOfTransport(transportService));
        webCommandMap.put("get transport", new GetTransportName(transportService));
        webCommandMap.put("GET /shop/count HTTP/1\\.1", new GetCountOfTransport(transportService));
        webCommandMap.put(".+/item\\?get_info=.+", new GetTransportName(transportService));
    }

    public WebCommand getCommandFromMap(String key) {
        Optional<String> optional = webCommandMap.keySet().stream()
                .filter(key::matches)
                .findFirst();
        return webCommandMap.get(optional.orElse(null));
    }
}
