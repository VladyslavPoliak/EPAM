package task7_4;

import task7_3.Transport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransportCreator implements Creator, InvocationHandler {

    private Transport transport;

    @Override
    public Transport create() {
        return transport = setProxy();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            throw new UnsupportedOperationException();
        }
        return method.invoke(transport, args);
    }

    private Transport setProxy() {
        return (Transport) Proxy.newProxyInstance(Transport.class.getClassLoader(),
                new Class[]{Transport.class}, new TransportCreator());
    }
}
