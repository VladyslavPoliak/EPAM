package com.epam.poliak.creator.impl;

import com.epam.poliak.creator.TransportCreator;
import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.input.InputHelper;

public class BicycleCreator implements TransportCreator {

    @Override
    public Bicycles create(InputHelper helper) {
        Bicycles bicycles = new Bicycles();
        fillTransport(bicycles, helper);
        System.out.println("WheelSize: ");
        bicycles.setWheelSize(helper.getInteger());
        System.out.println("NumberAbsorber: ");
        bicycles.setNumberAbsorber(helper.getInteger());
        return bicycles;
    }
}
