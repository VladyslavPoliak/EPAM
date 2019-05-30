package com.epam.poliak.factory.random;

import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.factory.FactoryInterface;

public class RandomBicycles implements FactoryInterface<Bicycles> {

    @Override
    public Bicycles create() {
        Bicycles bicycles = new Bicycles();
        bicycles.setProducer("Producer" + createRandomNumber(100, 2000));
        bicycles.setPrice(createRandomNumber(10000, 100000));
        bicycles.setNumberAbsorber(createRandomNumber(1, 10));
        bicycles.setWheelSize(createRandomNumber(10, 30));
        return bicycles;
    }
}
