package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.factory.Builder;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;

import java.util.Scanner;

public class AddNewTransport implements Command {

    private Builder builder;

    private TransportService transportService;

    public AddNewTransport(TransportService transportService, Builder builder) {
        this.transportService = transportService;
        this.builder = builder;
    }

    @Override
    public void doCommand() {
        System.out.println(Constants.ADD_NEW_TRANSPORT_MENU);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Transport");
        String choose = scanner.next();
        builder.chooseTransportType(choose).create();
        transportService.addNewTransport(builder.chooseTransportType(choose).create());
        System.out.println("Successfully added!");
    }
}
