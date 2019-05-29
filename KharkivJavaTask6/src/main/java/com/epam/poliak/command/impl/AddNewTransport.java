package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.factory.FactoryInterface;
import com.epam.poliak.input.InputStrategy;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;

import java.util.Scanner;

public class AddNewTransport implements Command {

    private TransportService transportService;
    private FactoryInterface factoryInterface;

    public AddNewTransport(TransportService transportService,FactoryInterface factoryInterface) {
        this.transportService = transportService;
        this.factoryInterface=factoryInterface;
    }

    @Override
    public void doCommand() {
        System.out.println(Constants.ADD_NEW_TRANSPORT_MENU);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Transport");
        int x = scanner.nextInt();
        if (x == 1) {
            transportService.addNewTransport(factoryInterface.createCar());
        }else {
            transportService.addNewTransport(factoryInterface.createBicycles());
        }

    }
}
