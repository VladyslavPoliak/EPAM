package com.epam.poliak.creator;

import com.epam.poliak.annotation.Setter;
import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.input.InputHelper;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ReflectionCreator {

    private Logger logger = Logger.getLogger(ReflectionCreator.class);
    private Map<String, Transport> transportMap;

    public ReflectionCreator() {
        transportMap = new HashMap<>();
        transportMap.put("1", new Bicycles());
        transportMap.put("2", new Car());
        transportMap.put("3", new CargoCar());
        transportMap.put("4", new Transport());
    }

    public Transport create(String transportType, ResourceBundle bundle, InputHelper inputHelper) {
        Transport transport = transportMap.get(transportType);
        Class transportClass = transport.getClass();
        for (Method method : transportClass.getMethods()) {
            if (method.isAnnotationPresent(Setter.class)) {
                System.out.println(bundle.getString(method.getAnnotation(Setter.class).name()));
                Class[] methodParameterTypes = method.getParameterTypes();
                try {
                    method.invoke(transport, setObjectValues(methodParameterTypes[0], inputHelper));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.error("Error");
                }
            }
        }
        return transport;
    }

    private Object setObjectValues(Class parameterType, InputHelper inputHelper) {
        Object resultObject = null;
        Class inputHelperClass = inputHelper.getClass();
        Method[] allMethods = inputHelperClass.getMethods();
        for (Method method : allMethods) {
            if (parameterType.equals(method.getReturnType())) {
                try {
                    resultObject = method.invoke(inputHelper);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.error("Error");
                }
                break;
            }
        }
        return resultObject;
    }

}
