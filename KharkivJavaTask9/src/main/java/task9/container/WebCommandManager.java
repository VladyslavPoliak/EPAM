package task9.container;

import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;
import task9.server.AbstractCommand;
import task9.server.http.GetCountHttp;
import task9.server.http.GetNameHttp;
import task9.server.tcp.GetCountTcp;
import task9.server.tcp.GetNameTcp;
import task9.threads.AbstractFactory;
import task9.threads.httpFactory.HttpFactory;
import task9.threads.tcpFactory.TcpFactory;

import java.util.HashMap;
import java.util.Map;

public class WebCommandManager {

    private TransportService transportService;

    public WebCommandManager(TransportService transportService) {
        this.transportService = transportService;
    }

    public Map<String, AbstractCommand> initWebCommandMap() {
        Map<String, AbstractCommand> webCommandMap = new HashMap<>();
        webCommandMap.put("get count", new GetCountTcp(transportService));
        webCommandMap.put("get transport", new GetNameTcp(transportService));
        webCommandMap.put(".+/shop/count HTTP/1\\.1", new GetCountHttp(transportService));
        webCommandMap.put(".+/item\\?get_info=.+", new GetNameHttp(transportService));
        return webCommandMap;
    }

    public Map<Integer, AbstractFactory> initFactory() {
        Map<Integer, AbstractFactory> factoryMap = new HashMap<>();
        factoryMap.put(Constants.PORT_FOR_TCP, new TcpFactory());
        factoryMap.put(Constants.PORT_FOR_HTTP, new HttpFactory());
        return factoryMap;
    }
}
