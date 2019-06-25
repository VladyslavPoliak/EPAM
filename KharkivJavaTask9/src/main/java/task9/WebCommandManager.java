package task9;

import com.epam.poliak.service.TransportService;
import task9.factory.impl.CreateHttpCommands;
import task9.factory.impl.CreateTcpCommands;
import task9.handler.Handler;
import task9.handler.impl.GetCountHandler;
import task9.handler.impl.GetNameHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WebCommandManager {

    private Map<String, Handler> webCommandMap = new HashMap<>();
    private TransportService transportService;

    public WebCommandManager(TransportService transportService) {
        this.transportService = transportService;
        fillMap();
    }

    private void fillMap() {
        webCommandMap.put("get count", new GetCountHandler(new CreateTcpCommands(transportService)));
        webCommandMap.put("get transport", new GetNameHandler(new CreateTcpCommands(transportService)));
        webCommandMap.put(".+/shop/count HTTP/1\\.1", new GetCountHandler(new CreateHttpCommands(transportService)));
        webCommandMap.put(".+/item\\?get_info=.+", new GetNameHandler(new CreateHttpCommands(transportService)));
    }

    public Handler getCommandFromMap(String key) {
        Optional<String> optional = webCommandMap.keySet().stream()
                .filter(key::matches)
                .findFirst();
        return webCommandMap.get(optional.orElse(null));
    }
}
