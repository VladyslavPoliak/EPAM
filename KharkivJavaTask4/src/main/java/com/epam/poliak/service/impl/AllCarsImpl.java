package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.AllCars;
import com.epam.poliak.utils.Utils;

import java.util.List;

public class AllCarsImpl implements AllCars {

    private List<Transport> allItemList;

    @Override
    public void showListCars() {
        allItemList = Utils.getAllItemList();
        if (!allItemList.isEmpty()) {
            allItemList.forEach(System.out::println);
        } else {
            System.out.println("Sorry, there are no cars at the moment. Try later");
        }
    }
}
