package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.AllCarsService;

public class AllItemCommand implements Command {

    private AllCarsService allCarsService;

    public AllItemCommand(AllCarsService allCarsService) {
        this.allCarsService = allCarsService;
    }

    @Override
    public void doCommand() {
        allCarsService.showListCars();
    }
}
