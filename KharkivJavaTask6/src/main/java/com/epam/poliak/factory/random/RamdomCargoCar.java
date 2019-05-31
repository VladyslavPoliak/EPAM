package com.epam.poliak.factory.random;

import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.factory.FactoryInterface;

public class RamdomCargoCar implements FactoryInterface {

    @Override
    public CargoCar create() {
        CargoCar cargoCar = new CargoCar();
        randomFillCommonData(cargoCar);
        cargoCar.setMaxTransportWeight(createRandomNumber(1000, 10000));
        cargoCar.setNumberOfTrailers(createRandomNumber(1, 10));
        cargoCar.setYearOfRelease(createRandomNumber(200, 2019));
        cargoCar.setEnginePower(createRandomNumber(500, 2000));
        return cargoCar;
    }
}
