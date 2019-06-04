package com.epam.poliak.command.impl;
import com.epam.poliak.annotation.Setter;
import com.epam.poliak.command.Command;
import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;

import org.apache.log4j.Logger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddNewTransportReflection implements Command {

    private InputHelper inputHelper;
    private TransportService transportService;
    private Map<String, Transport> transportMap = new HashMap<>();
    private Logger logger = Logger.getLogger(AddNewTransportReflection.class);
    private ResourceBundle bundle ;

    public AddNewTransportReflection(TransportService transportService, InputHelper inputHelper,ResourceBundle bundle) {
        this.inputHelper = inputHelper;
        this.transportService = transportService;
        this.bundle=bundle;
        transportMap.put("1", new Bicycles());
        transportMap.put("2", new Car());
        transportMap.put("3", new CargoCar());
        transportMap.put("4", new Transport());
    }

    @Override
    public void doCommand() {
        System.out.println(Constants.ADD_NEW_TRANSPORT_MENU);
        System.out.println("Choose Transport");
        Scanner sc = new Scanner(System.in);
        Transport transport =  create(sc.next());
        transportService.addNewTransport(transport);
    }

    private Transport create(String transportType) {
        Transport transport = transportMap.get(transportType);
        Class transportClass = transport.getClass();
        for (Method method : transportClass.getMethods()) {
            if (method.isAnnotationPresent(Setter.class)) {
                String annotationName = method.getAnnotation(Setter.class).name();
                System.out.println(bundle.getString(annotationName));
                Class[] methodParameterTypes = method.getParameterTypes();
                try {
                    method.invoke(transport, getValue(methodParameterTypes[0]));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    logger.error("Error");
                }
            }
        }
        return transport;
    }

    private Object getValue(Class parameterType) {
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
