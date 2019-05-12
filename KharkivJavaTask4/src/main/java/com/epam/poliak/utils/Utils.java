package com.epam.poliak.utils;

import com.epam.poliak.entity.Transport;
import org.apache.log4j.Logger;

import java.util.Hashtable;

public final class Utils {

    private static final Logger LOGGER = Logger.getLogger(Utils.class);
    private static Hashtable<Transport, Integer> shoppingCart = new Hashtable<>();

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
}
