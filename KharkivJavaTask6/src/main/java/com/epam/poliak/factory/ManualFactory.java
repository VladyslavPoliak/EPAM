package com.epam.poliak.factory;

import com.epam.poliak.entity.Bicycles;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.CargoCar;
import com.epam.poliak.entity.Transport;

import java.util.Scanner;

public class ManualFactory {

    private Scanner scanner = new Scanner(System.in);

//    @Override
//    public Bicycles createBicycles() {
//        Bicycles bicycles = new Bicycles();
//        fillTransport(bicycles);
//        System.out.println("Enter Number Absorber ");
//        bicycles.setNumberAbsorber(scanner.nextInt());
//        System.out.println("Enter Wheel Size");
//        bicycles.setWheelSize(scanner.nextInt());
//        return bicycles;
//    }
//
//    @Override
//    public Car createCar() {
//        Car car = new Car();
//        fillTransport(car);
//        System.out.println("Enter Engine Power");
//        car.setEnginePower(scanner.nextInt());
//        System.out.println("Enter Year Of Release");
//        car.setYearOfRelease(scanner.nextInt());
//        return car;
//    }
//
//    @Override
//    public CargoCar createCargoCar() {
//        CargoCar cargoCar = new CargoCar();
//        fillTransport(cargoCar);
//        System.out.println("Enter Year Of Release");
//        cargoCar.setYearOfRelease(scanner.nextInt());
//        System.out.println("Enter Engine Power");
//        cargoCar.setEnginePower(scanner.nextInt());
//        System.out.println("Enter Max Transport Weight");
//        cargoCar.setMaxTransportWeight(scanner.nextInt());
//        System.out.println("Enter Number Of Trailers");
//        cargoCar.setNumberOfTrailers(scanner.nextInt());
//        return cargoCar;
//    }
//
//    @Override
//    public Transport createTransport() {
//        Transport transport = new Transport();
//        fillTransport(transport);
//        return transport;
//    }
//
//    @Override
//    public void fillTransport(Transport transport) {
//        System.out.println("Enter producer");
//        transport.setProducer(scanner.next());
//        System.out.println("Enter price");
//        transport.setPrice(scanner.nextInt());
//    }
}
