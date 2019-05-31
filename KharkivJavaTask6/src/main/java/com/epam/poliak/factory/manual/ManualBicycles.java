package com.epam.poliak.factory.manual;

import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.factory.FactoryInterface;

public class ManualBicycles implements FactoryInterface {

    @Override
    public Bicycles create() {
        Bicycles bicycles = new Bicycles();
        manualFillCommonData(bicycles);
        System.out.println("Enter Number Absorber ");
        bicycles.setNumberAbsorber(scanner.nextInt());
        System.out.println("Enter Wheel Size");
        bicycles.setWheelSize(scanner.nextInt());
        return bicycles;
    }
}
