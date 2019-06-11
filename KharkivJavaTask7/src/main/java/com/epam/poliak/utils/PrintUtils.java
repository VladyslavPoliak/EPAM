package com.epam.poliak.utils;

import com.epam.poliak.entity.Transport;

import java.util.Date;
import java.util.Map;

public class PrintUtils {

    public static void printMenu() {
        System.out.println();
        System.out.println(Constants.MENU);
    }

    public static void getSearchResults(Map<Date, Map<Transport, Integer>> map) {
        if (map.isEmpty()) {
            System.out.println("Nothing found");
        } else {
            System.out.println(map.size() + " orders found");
            map.forEach(PrintUtils::printMap);
        }
    }

    private static void printMap(Date k, Map<Transport, Integer> v) {
        v.forEach((val, key) -> System.out.println("Date: " + k + " " + val + " Rental days: " + key));
    }
}
