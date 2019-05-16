package com.epam.poliak.utils;

public final class Constants {

    //    public static final String DATE = "(?Um)(^\\d{4}\\.\\d{2}\\.\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$)";
    public static final String DATE = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)";
    public static final String NUMBERS = "(?Um)(^\\d+$)";
    private static final String SEPARATOR = System.lineSeparator();
    public static final String MENU = "1 - display the list of cars" + SEPARATOR
            + "2 - add car to cart" + SEPARATOR + "3 - view the contents of the basket"
            + SEPARATOR + "4 - Checkout" + SEPARATOR
            + "5 - view information about the last 5 machines," +
            "were added to the cart in all purchase sessions." + SEPARATOR
            + "6 - view orders" + SEPARATOR + "7 - Search by time interval"
            + SEPARATOR + "8 - Search for nearest date" + SEPARATOR;

    private Constants() {

    }

}
