package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.creator.ReflectionCreator;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.service.TransportService;
import com.epam.poliak.utils.Constants;

import java.util.ResourceBundle;
import java.util.Scanner;

public class AddNewTransportReflection implements Command {

    private InputHelper inputHelper;
    private TransportService transportService;
    private ResourceBundle bundle;
    private ReflectionCreator creator;

    public AddNewTransportReflection(TransportService transportService, InputHelper inputHelper, ResourceBundle bundle) {
        this.inputHelper = inputHelper;
        this.transportService = transportService;
        this.bundle = bundle;
        creator = new ReflectionCreator();
    }

    @Override
    public void doCommand() {
        System.out.println(Constants.ADD_NEW_TRANSPORT_MENU);
        System.out.println("Choose Transport");
        Scanner sc = new Scanner(System.in);
        Transport transport = creator.create(sc.next(), bundle, inputHelper);
        transportService.addNewTransport(transport);
    }
}
