package com.epam.poliak.factory;

import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.entity.Transport;
import org.apache.log4j.Logger;

import java.util.Random;

public class RandomFactory implements FactoryInterface {

    private Random random = new Random();
    private Logger logger = Logger.getLogger(RandomFactory.class);

    @Override
    public Bicycles createBicycles() {
        logger.info("createBicycles");
        Bicycles bicycles = new Bicycles();
        fillTransport(bicycles);
        bicycles.setNumberAbsorber(createRandomNumber(1, 10));
        bicycles.setWheelSize(createRandomNumber(10, 30));
        return bicycles;
    }

    @Override
    public Car createCar() {
        logger.info("createCar");
        Car car = new Car();
        fillTransport(car);
        car.setEnginePower(createRandomNumber(50, 1500));
        car.setYearOfRelease(createRandomNumber(2000, 2019));
        return car;
    }

    @Override
    public CargoCar createCargoCar() {
        logger.info("createCargoCar");
        CargoCar cargoCar = new CargoCar();
        fillTransport(cargoCar);
        cargoCar.setMaxTransportWeight(createRandomNumber(1000, 10000));
        cargoCar.setNumberOfTrailers(createRandomNumber(1, 10));
        cargoCar.setYearOfRelease(createRandomNumber(200, 2019));
        cargoCar.setEnginePower(createRandomNumber(500, 2000));
        return cargoCar;
    }

    @Override
    public Transport createTransport() {
        Transport transport = new Transport();
        fillTransport(transport);
        return transport;
    }

    @Override
    public void fillTransport(Transport transport) {
        transport.setProducer("Producer" + createRandomNumber(100, 2000));
        transport.setPrice(createRandomNumber(10000, 100000));
    }

    private int createRandomNumber(int minNumber, int maxNumber) {
        int diffYear = maxNumber - minNumber;
        return random.nextInt(diffYear + 1) + minNumber;
    }
}
