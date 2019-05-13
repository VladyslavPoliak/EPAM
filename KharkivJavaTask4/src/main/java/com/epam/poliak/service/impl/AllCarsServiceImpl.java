package com.epam.poliak.service.impl;

import com.epam.poliak.dao.AllCarsDao;
import com.epam.poliak.service.AllCarsService;

public class AllCarsServiceImpl implements AllCarsService {

    private AllCarsDao allCarsDao = new AllCarsDao();

    @Override
    public void showListCars() {
        if (!allCarsDao.getAllItemList().isEmpty()) {
            allCarsDao.getAllItemList().forEach(System.out::println);
        } else {
            System.out.println("Sorry, there are no cars at the moment. Try later");
        }
    }
}
