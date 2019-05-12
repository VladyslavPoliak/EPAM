package com.epam.poliak.dao;

import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;

import java.util.ArrayList;
import java.util.List;

public class AllCarsDao {

    private static AllCarsDao allCarsDao;
    private List<Transport> allItemList;

    public AllCarsDao() {
        fillItemList();
    }

    public List<Transport> getAllItemList() {
        return allItemList;
    }

    public void setAllItemList(List<Transport> allItemList) {
        this.allItemList = allItemList;
    }

    public void updateAllItemList(int index) {
        allItemList.remove(index);
        for (int i = 0; i < allItemList.size(); i++) {
            allItemList.get(i).setId(i);
        }
    }

    private void fillItemList() {
        allItemList = new ArrayList<>();
        allItemList.add(new Car(0, 5500, "Nissan", 200, 2011));
        allItemList.add(new Car(1, 5000, "Nissan", 150, 2010));
        allItemList.add(new Car(2, 6000, "Toyota", 152, 2011));
        allItemList.add(new Car(3, 2000, "Mazda", 155, 2014));
        allItemList.add(new Car(4, 7000, "Nissan", 140, 2013));
        allItemList.add(new Car(5, 4000, "Nissan", 145, 2014));
        allItemList.add(new Car(6, 2000, "Chevrolet", 100, 2010));

    }

    public static AllCarsDao getInstance() {
        if (allCarsDao == null) {
            allCarsDao = new AllCarsDao();
            return allCarsDao;
        }
        return allCarsDao;
    }
}
