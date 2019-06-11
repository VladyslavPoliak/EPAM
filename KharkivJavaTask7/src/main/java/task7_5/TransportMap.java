package task7_5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TransportMap implements InvocationHandler {

    private static final int SUBSTRING_GET_OR_SET = 3;
    private Map<String, Object> transportMap = new HashMap<>();
    private Map<Class, Object> defaultValues = addDefaultValuesForMap();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            return putIntoMap(method, args);
        } else if (method.getName().startsWith("get")) {
            return getFromMap(method);
        }
        throw new NoSuchMethodException();
    }

    private Map<Class, Object> addDefaultValuesForMap() {
        HashMap<Class, Object> mapForDefaultValues = new HashMap<>();
        mapForDefaultValues.put(int.class, 0);
        mapForDefaultValues.put(String.class, null);
        return mapForDefaultValues;
    }

    private Object putIntoMap(Method method, Object[] args) {
        return transportMap.put(method.getName().substring(SUBSTRING_GET_OR_SET).toLowerCase(), args[0]);
    }

    private Object getFromMap(Method method) {
        Object methodValue = transportMap.get(method.getName().substring(SUBSTRING_GET_OR_SET).toLowerCase());
        return Objects.isNull(methodValue) ? defaultValues.get(method.getReturnType()) : methodValue;
    }
}
