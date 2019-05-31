package com.epam.poliak.utils;

public final class Constants {

    public static final String DATE = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)";
    public static final String NUMBERS = "(?Um)(^\\d+$)";
    public static final String MANUAL = "MANUAL";
    public static final String RANDOM = "RANDOM";
    private static final String SEPARATOR = System.lineSeparator();
    public static final String MENU = "1 - display the list of cars" + SEPARATOR
            + "2 - add car to cart" + SEPARATOR + "3 - view the contents of the basket"
            + SEPARATOR + "4 - Make order" + SEPARATOR
            + "5 - view information about the last 5 cars," +
            "were added to the cart in all purchase sessions." + SEPARATOR
            + "6 - Search order by date " + SEPARATOR + "7 - Search by time interval"
            + SEPARATOR + "8 - Search for nearest date" + SEPARATOR
            + "9 - Add new Transport" + SEPARATOR
            + "0 - exit " + SEPARATOR;
    public static final String ADD_NEW_TRANSPORT_MENU = "1 - add Bicycles" + SEPARATOR
            + "2 - add Car" + SEPARATOR
            + "3 - add Cargo Car" + SEPARATOR
            + "4 - add Transport";

    private Constants() {

    }

}
