package com.epam.poliak.creator.impl;

import com.epam.poliak.creator.TransportCreator;
import com.epam.poliak.entity.Car;
import com.epam.poliak.input.InputHelper;

public class CarCreator implements TransportCreator {

    @Override
    public Car create(InputHelper helper) {
        Car car = new Car();
        fillCommonData(car, helper);
        car.setYearOfRelease(helper.getInteger("Year Of Release: "));
        car.setEnginePower(helper.getInteger("Engine Power: "));
        return car;
    }
}
