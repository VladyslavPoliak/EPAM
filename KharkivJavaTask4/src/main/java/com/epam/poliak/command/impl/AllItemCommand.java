package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.TransportService;

public class AllItemCommand implements Command {

    private TransportService transportService;

    public AllItemCommand(TransportService transportService) {
        this.transportService = transportService;
    }

    @Override
    public void doCommand() {
        transportService.showListCars();
    }
}
