package com.epam.poliak.service.impl;

import com.epam.poliak.dao.AllCarsDao;
import com.epam.poliak.dao.impl.AllCarsDaoImpl;
import com.epam.poliak.service.AllCarsService;

public class AllCarsServiceImpl implements AllCarsService {

    private AllCarsDao allCarsDao = new AllCarsDaoImpl();

    @Override
    public void showListCars() {
        allCarsDao.showAllCarsList();
    }
}
