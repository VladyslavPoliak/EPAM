package task7_5;

import task7_4.Creator;
import task7_3.Transport;

import java.lang.reflect.Proxy;

public class MapHandler implements Creator {

    @Override
    public Transport create() {
        return (Transport) Proxy.newProxyInstance(Transport.class.getClassLoader(),
                new Class[]{Transport.class}, new TransportMap());
    }
}
