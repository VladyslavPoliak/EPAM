package com.epam.poliak.command.impl;

import com.epam.poliak.command.Command;
import com.epam.poliak.dao.AllCarsDao;
import com.epam.poliak.service.AllCarsService;
import com.epam.poliak.service.impl.AllCarsServiceImpl;

public class AllItemCommand implements Command {

    private AllCarsService allCarsService = new AllCarsServiceImpl();
    private AllCarsDao allCarsDao = new AllCarsDao();

    @Override
    public void doCommand() {
        allCarsService.showListCars(allCarsDao.getAllItemList());
    }
}
