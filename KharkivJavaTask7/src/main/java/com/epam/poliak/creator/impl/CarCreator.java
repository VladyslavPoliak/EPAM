package com.epam.poliak.creator.impl;

import com.epam.poliak.creator.TransportCreator;
import com.epam.poliak.entity.Car;
import com.epam.poliak.input.InputHelper;

public class CarCreator implements TransportCreator {

    @Override
    public Car create(InputHelper helper) {
        Car car = new Car();
        fillCar(car, helper);
        return car;
    }
}
