package com.epam.poliak.command.commandImpl;

import com.epam.poliak.command.Command;
import com.epam.poliak.service.AllCars;
import com.epam.poliak.service.impl.AllCarsImpl;

public class AllItemCommand implements Command {

    @Override
    public void doCommand() {
        AllCars allCars = new AllCarsImpl();
        allCars.showListCars();
        System.out.println();
    }
}
