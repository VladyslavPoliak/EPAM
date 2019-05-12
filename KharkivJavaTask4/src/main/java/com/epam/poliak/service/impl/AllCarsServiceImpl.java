package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.AllCarsService;

import java.util.List;

public class AllCarsServiceImpl implements AllCarsService {

    @Override
    public void showListCars(List<Transport> list) {
        if (!list.isEmpty()) {
            list.forEach(System.out::println);
        } else {
            System.out.println("Sorry, there are no cars at the moment. Try later");
        }
    }
}
