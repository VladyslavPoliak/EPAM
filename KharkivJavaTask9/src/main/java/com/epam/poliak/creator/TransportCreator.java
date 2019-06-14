package com.epam.poliak.creator;

import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.input.InputHelper;

public interface TransportCreator {

    Transport create(InputHelper helper);

    default void fillTransport(Transport transport, InputHelper helper) {
        System.out.println("Price: ");
        transport.setPrice(helper.getInteger());
        System.out.println("Producer");
        transport.setProducer(helper.getString());
    }

    default void fillCar(Car car, InputHelper helper) {
        fillTransport(car, helper);
        System.out.println("Year Of Release: ");
        car.setYearOfRelease(helper.getInteger());
        System.out.println("Engine Power: ");
        car.setEnginePower(helper.getInteger());
    }


}
