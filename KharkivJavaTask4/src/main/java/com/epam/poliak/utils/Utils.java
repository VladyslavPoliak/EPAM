package com.epam.poliak.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("ds");
        return new Date();
    }
}
