package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.AllCarsService;
import com.epam.poliak.service.impl.ServiceManager;

public class AllItemCommand implements Command {

    private AllCarsService allCarsService = ServiceManager.getInstance().getAllCarsService();

    @Override
    public void doCommand() {
        allCarsService.showListCars();
    }
}
