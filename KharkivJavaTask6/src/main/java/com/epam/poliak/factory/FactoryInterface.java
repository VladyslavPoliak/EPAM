package com.epam.poliak.factory;

import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.entity.Transport;

public interface FactoryInterface {

    Bicycles createBicycles();

    Car createCar();

    CargoCar createCargoCar();

    Transport createTransport();

    void fillTransport(Transport transport);

}
