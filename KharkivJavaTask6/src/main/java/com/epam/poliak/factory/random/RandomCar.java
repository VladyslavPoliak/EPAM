package com.epam.poliak.factory.random;

import com.epam.poliak.entity.Car;
import com.epam.poliak.factory.FactoryInterface;

public class RandomCar implements FactoryInterface {

    @Override
    public Car create() {
        Car car = new Car();
        randomFillCommonData(car);
        car.setEnginePower(createRandomNumber(50, 1500));
        car.setYearOfRelease(createRandomNumber(2000, 2019));
        return car;
    }

}
