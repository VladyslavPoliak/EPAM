package com.epam.poliak.utils;

public final class Constants {

    public static final String NUMBERS = "(?Um)(^\\d+$)";
    private static final String SEPARATOR = System.lineSeparator();
    public static final String MENU = "1 - display the list of cars" + SEPARATOR
            + "2 - add car to cart" + SEPARATOR + "3 - view the contents of the basket"
            + SEPARATOR + "4 - Checkout" + SEPARATOR
            + "5 - view information about the last 5 machines," +
            "were added to the cart in all purchase sessions." + SEPARATOR;

    private Constants() {

    }

}
