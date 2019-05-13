package com.epam.poliak.service.impl;

import com.epam.poliak.dao.AllTransportDao;
import com.epam.poliak.service.AllCarsService;

public class AllCarsServiceImpl implements AllCarsService {

    private AllTransportDao allTransportDao = new AllTransportDao();

    @Override
    public void showListCars() {
        if (!allTransportDao.getAllItemList().isEmpty()) {
            allTransportDao.getAllItemList().forEach(System.out::println);
        } else {
            System.out.println("Sorry, there are no cars at the moment. Try later");
        }
    }
}
