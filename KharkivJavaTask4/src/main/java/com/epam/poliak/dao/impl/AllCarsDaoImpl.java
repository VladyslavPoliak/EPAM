package com.epam.poliak.dao.impl;

import com.epam.poliak.dao.AllCarsDao;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;

import java.util.ArrayList;
import java.util.List;

public class AllCarsDaoImpl implements AllCarsDao {

    private static List<Transport> allItemList;

    public AllCarsDaoImpl() {
        allItemList = getInstance();
    }

    @Override
    public void showAllCarsList() {
        if (!allItemList.isEmpty()) {
            allItemList.forEach(System.out::println);
        } else {
            System.out.println("Sorry, there are no cars at the moment. Try later");
        }
    }

    public List<Transport> getAllItemList() {
        return allItemList;
    }

    public void setAllItemList(List<Transport> allItemList) {
        AllCarsDaoImpl.allItemList = allItemList;
    }

    public void updateAllItemList(int index) {
        allItemList.remove(index);
    }

    private void fillItemList() {
        if (allItemList.isEmpty()) {
            allItemList.add(new Car(0, 5500, "Nissan", 200, 2011));
            allItemList.add(new Car(1, 5000, "Nissan", 150, 2010));
            allItemList.add(new Car(2, 6000, "Toyota", 152, 2011));
            allItemList.add(new Car(3, 2000, "Mazda", 155, 2014));
            allItemList.add(new Car(4, 7000, "Nissan", 140, 2013));
            allItemList.add(new Car(5, 4000, "Nissan", 145, 2014));
            allItemList.add(new Car(6, 2000, "Chevrolet", 100, 2010));
        }
    }

    private List<Transport> getInstance() {
        if (allItemList == null) {
            allItemList = new ArrayList<>();
            fillItemList();
            return allItemList;
        }
        return allItemList;
    }
}
