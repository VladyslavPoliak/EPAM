package task7_5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TransportMap implements InvocationHandler {

    private static final int SUBSTRING_GET_OR_SET = 3;
    private Map<String, Object> transportMap = new HashMap<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            return transportMap.put(method.getName().substring(SUBSTRING_GET_OR_SET).toLowerCase(), args[0]);
        } else if (method.getName().startsWith("get")) {
            return transportMap.get(method.getName().substring(SUBSTRING_GET_OR_SET).toLowerCase());
        }
        throw new NoSuchMethodException();
    }
}
