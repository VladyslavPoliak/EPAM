package com.epam.poliak.creator.impl;

import com.epam.poliak.creator.TransportCreator;
import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.input.InputHelper;

public class BicycleCreator implements TransportCreator {

    @Override
    public Bicycles create(InputHelper helper) {
        Bicycles bicycles = new Bicycles();
        fillCommonData(bicycles, helper);
        bicycles.setWheelSize(helper.getInteger("WheelSize: "));
        bicycles.setNumberAbsorber(helper.getInteger("NumberAbsorber: "));
        return bicycles;
    }
}
