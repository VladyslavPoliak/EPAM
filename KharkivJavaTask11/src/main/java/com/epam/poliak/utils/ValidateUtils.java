package com.epam.poliak.utils;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidateUtils {

    private ValidateUtils() {
    }

    public static boolean validateEnter(String s, String patt) {
        Pattern pattern = Pattern.compile(patt);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return true;
        }
        throw new InputMismatchException();
    }

    public static int validateDays(int number) {
        if (number <= 0) {
            return 1;
        }
        return number;
    }
}
