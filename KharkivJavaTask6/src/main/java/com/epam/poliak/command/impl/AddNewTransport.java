package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.factory.FactoryInterface;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddNewTransport implements Command {

    private TransportService transportService;
    private FactoryInterface factoryInterface;

    public AddNewTransport(TransportService transportService, FactoryInterface factoryInterface) {
        this.transportService = transportService;
        this.factoryInterface = factoryInterface;
    }

    @Override
    public void doCommand() {
        System.out.println(Constants.ADD_NEW_TRANSPORT_MENU);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Transport");
        int x = scanner.nextInt();
        Map<Integer, Transport> map = new HashMap<>();
        map.put(1, new  );
        map.put(2, factoryInterface.createBicycles());
        map.put(3, factoryInterface.createCargoCar());
        transportService.addNewTransport(map.get(x));
    }
}
