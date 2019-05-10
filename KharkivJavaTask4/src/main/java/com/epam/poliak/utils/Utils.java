package com.epam.poliak.utils;

import com.epam.poliak.entity.Transport;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public final class Utils {

    private static final Logger LOGGER = Logger.getLogger(Utils.class);
    private static Hashtable<Transport, Integer> shoppingCart = new Hashtable<>();
    private static List<Transport> allItemList = new ArrayList<>();

    private Utils() {
    }

    public static void printMenu() {
        System.out.println();
        System.out.println(Constants.MENU);
    }

    public static Hashtable<Transport, Integer> getCurrentShoppingCart() {
        return shoppingCart;
    }

    public static void setCurrentShoppingCart(Hashtable<Transport, Integer> shoppingCart) {
        Utils.shoppingCart = shoppingCart;
    }

//    public static void fillItemList() {
//        allItemList = Utils.getAllItemList();
//        allItemList.clear();
//        allItemList.add(new Car(0, 5500, "Nissan", 200, 2011));
//        allItemList.add(new Car(1, 5000, "Nissan", 150, 2010));
//        allItemList.add(new Car(2, 6000, "Toyota", 152, 2011));
//        allItemList.add(new Car(3, 2000, "Mazda", 155, 2014));
//        allItemList.add(new Car(4, 7000, "Nissan", 140, 2013));
//        allItemList.add(new Car(5, 4000, "Nissan", 145, 2014));
//        allItemList.add(new Car(6, 2000, "Chevrolet", 100, 2010));
//        Utils.setAllItemList(allItemList);
//    }

//    public static List<Transport> getAllItemList() {
//        return allItemList;
//    }
//
//    public static void setAllItemList(List<Transport> allItemList) {
//        Utils.allItemList = allItemList;
//    }

//    public static void updateAllItemList(int index) {
//        Utils.allItemList.remove(index);
//    }
}
