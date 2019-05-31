package com.epam.poliak.factory.manual;

import com.epam.poliak.entity.Car;
import com.epam.poliak.factory.FactoryInterface;

import java.util.Scanner;

public class ManualCar implements FactoryInterface {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Car create() {
        Car car = new Car();
        manualFillCommonData(car);
        System.out.println("Enter Engine Power");
        car.setEnginePower(scanner.nextInt());
        System.out.println("Enter Year Of Release");
        car.setYearOfRelease(scanner.nextInt());
        return car;
    }
}
