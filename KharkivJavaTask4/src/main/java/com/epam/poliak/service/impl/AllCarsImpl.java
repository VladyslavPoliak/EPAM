package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.AllCars;

import java.util.ArrayList;
import java.util.List;

public class AllCarsImpl implements AllCars {

    private List<Transport> allItemList = new ArrayList<>();

    public AllCarsImpl() {
        fillItemList();
    }

    @Override
    public void showListCars() {
        allItemList.forEach(System.out::println);
    }

    public List<Transport> getAllItemList() {
        return allItemList;
    }

    public void setAllItemList(List<Transport> allItemList) {
        this.allItemList = allItemList;
    }

    private void fillItemList() {
        allItemList.clear();
        allItemList.add(new Car(1, 5000, "Nissan", 150, 2010));
        allItemList.add(new Car(2, 6000, "Toyota", 152, 2011));
        allItemList.add(new Car(3, 2000, "Mazda", 155, 2014));
        allItemList.add(new Car(4, 7000, "Nissan", 140, 2013));
        allItemList.add(new Car(5, 4000, "Nissan", 145, 2014));
        allItemList.add(new Car(6, 2000, "Chevrolet", 100, 2010));
    }
}
