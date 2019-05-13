package com.epam.poliak.utils;

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
}
