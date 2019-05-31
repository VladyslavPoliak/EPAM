package com.epam.poliak.factory.manual;

import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.factory.FactoryInterface;

public class ManualCargoCar implements FactoryInterface {

    @Override
    public CargoCar create() {
        CargoCar cargoCar = new CargoCar();
        manualFillCommonData(cargoCar);
        System.out.println("Enter Year Of Release");
        cargoCar.setYearOfRelease(scanner.nextInt());
        System.out.println("Enter Engine Power");
        cargoCar.setEnginePower(scanner.nextInt());
        System.out.println("Enter Max Transport Weight");
        cargoCar.setMaxTransportWeight(scanner.nextInt());
        System.out.println("Enter Number Of Trailers");
        cargoCar.setNumberOfTrailers(scanner.nextInt());
        return cargoCar;
    }
}
