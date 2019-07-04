package com.epam.poliak.utils;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.io.Writer;
import com.epam.poliak.io.impl.WriterImpl;

import java.util.Date;
import java.util.Map;

public class PrintUtils {

    private static Writer writer = new WriterImpl();

    public static void printMenu() {
        writer.writeLine(Constants.MENU);
    }

    public static void getSearchResults(Map<Date, Map<Transport, Integer>> map) {
        if (map.isEmpty()) {
            writer.writeLine("Nothing found");
        } else {
            writer.writeLine(map.size() + " orders found");
            map.forEach(PrintUtils::printMap);
        }
    }

    private static void printMap(Date k, Map<Transport, Integer> v) {
        v.forEach((val, key) -> writer.writeLine("Date: " + k + " " + val + " Rental days: " + key));
    }
}
