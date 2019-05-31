package com.epam.poliak.factory.random;

import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.factory.FactoryInterface;

public class RandomBicycles implements FactoryInterface {

    @Override
    public Bicycles create() {
        Bicycles bicycles = new Bicycles();
        randomFillCommonData(bicycles);
        bicycles.setNumberAbsorber(createRandomNumber(1, 10));
        bicycles.setWheelSize(createRandomNumber(10, 30));
        return bicycles;
    }
}
