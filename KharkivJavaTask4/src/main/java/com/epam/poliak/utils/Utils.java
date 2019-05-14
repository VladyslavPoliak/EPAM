package com.epam.poliak.utils;

import com.epam.poliak.entity.Transport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils {

    private Utils() {
    }

    public static void printMenu() {
        System.out.println();
        System.out.println(Constants.MENU);
    }

    public static boolean validateEnter(String s, String patt) {
        Pattern pattern = Pattern.compile(patt);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public static int validateNumber(int number) {
        if (number <= 0) {
            return 1;
        }
        return number;
    }

    public static Date getDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static Date getBeforeDate(Map<Date, Map<Transport, Integer>> map, Date date) {
        Date before = null;
        for (Map.Entry<Date, Map<Transport, Integer>> entry : map.entrySet()) {
            if (entry.getKey().before(date)) {
                before = entry.getKey();
            }
        }
        return before;
    }

    public static Date getAfterDate(Map<Date, Map<Transport, Integer>> map, Date date) {
        for (Map.Entry<Date, Map<Transport, Integer>> entry : map.entrySet()) {
            if (entry.getKey().after(date)) {
                return entry.getKey();
            }
        }
        return null;
    }

}
