package com.epam.poliak.factory.manual;

import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.factory.FactoryInterface;

import java.util.Scanner;

public class ManualBicycles implements FactoryInterface<Bicycles> {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Bicycles create() {
        Bicycles bicycles = new Bicycles();
        System.out.println("Enter producer");
        bicycles.setProducer(scanner.next());
        System.out.println("Enter price");
        bicycles.setPrice(scanner.nextInt());
        System.out.println("Enter Number Absorber ");
        bicycles.setNumberAbsorber(scanner.nextInt());
        System.out.println("Enter Wheel Size");
        bicycles.setWheelSize(scanner.nextInt());
        return bicycles;
    }
}
