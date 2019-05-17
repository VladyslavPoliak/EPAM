package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;

import java.util.ArrayList;

public class AllItemCommand implements Command {

    private TransportService transportService;

    public AllItemCommand(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public void doCommand() {
        ArrayList<Transport> allTransport = transportService.getAllTransport();
        if (!allTransport.isEmpty()) {
            allTransport.forEach(System.out::println);
        } else {
            System.out.println("Sorry, there are no cars at the moment. Try later");
        }
    }
}
