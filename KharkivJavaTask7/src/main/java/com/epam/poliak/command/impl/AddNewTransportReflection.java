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
    private ResourceBundle bundle = ResourceBundle.getBundle("content");

    public AddNewTransportReflection(TransportService transportService, InputHelper inputHelper) {
        this.inputHelper = inputHelper;
        this.transportService = transportService;
        transportMap.put("Transport", new Transport());
        transportMap.put("Car", new Car());
        transportMap.put("Bicycles", new Bicycles());
        transportMap.put("Cargo Car", new CargoCar());
    }

    @Override
    public void doCommand() {
        System.out.println(Constants.ADD_NEW_TRANSPORT_MENU);
        System.out.println("Choose Transport");
        Transport transport = getBike();
        transportService.addNewTransport(transport);
    }


    private Transport getBike() {
        Transport transport;
        Scanner sc = new Scanner(System.in);
        transport = create(sc.next());
        return transport;
    }

    private Transport create(String transportType) {
        Transport transport = transportMap.get(transportType);
        Class transportClass = transport.getClass();
        for (Method method : transportClass.getMethods()) {
            if (method.isAnnotationPresent(Setter.class)) {
                String annotationName = method.getAnnotation(Setter.class).name();
                System.out.println(bundle.getString("Enter") + " " + bundle.getString(annotationName));
                Class[] c = method.getParameterTypes();
                try {
                    method.invoke(transport, getValue(c[0]));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println("sdz");
                }
            }
        }
        return transport;
    }

    private Object getValue(Class aClass) {
        Object res = null;
        Class cl = inputHelper.getClass();
        Method[] methods = cl.getMethods();
        for (Method m : methods) {
            Class c = m.getReturnType();
            if (aClass.equals(c)) {
                try {
                    res = m.invoke(inputHelper, "szdfgas");
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println("sdz");
                }
                break;
            }
        }
        return res;
    }
}
