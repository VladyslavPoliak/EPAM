package com.epam.poliak.utils;

public final class Constants {

    public static final String HTTP_CODE_200 = "HTTP/1.1 200 OK";
    public static final String GET_ITEM_REQUEST_REGEXP = ".*get_info=(\\d{1,5}).*";
    public static final String START_REQUEST = "GET /shop";
    public static final int MAX_ITEMS_IN_LINKED_MAP = 5;
    public static final String EXIT_COMMAND = "0";
    public static final String DATE = "(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)";
    public static final String NUMBERS = "(?Um)(^\\d+$)";
    public static final String CONNECT_ERROR = "Error connecting to server";
    public static final String HOST = "localhost";
    public static final int PORT_FOR_TCP = 3000;
    public static final int PORT_FOR_HTTP = 8080;
    private static final String SEPARATOR = System.lineSeparator();
    static final String MENU = "1 - display the list of cars" + SEPARATOR
            + "2 - add car to cart" + SEPARATOR + "3 - view the contents of the basket"
            + SEPARATOR + "4 - Make order" + SEPARATOR
            + "5 - view information about the last 5 cars," +
            "were added to the cart in all purchase sessions." + SEPARATOR
            + "6 - Search order by date " + SEPARATOR + "7 - Search by time interval"
            + SEPARATOR + "8 - Search for nearest date" + SEPARATOR
            + "9 - Add new Transport" + SEPARATOR
            + "10 - Add new Transport by Reflection" + SEPARATOR
            + "0 - exit " + SEPARATOR;
    public static final String ADD_NEW_TRANSPORT_MENU = "1 - add Bicycles" + SEPARATOR
            + "2 - add Car" + SEPARATOR
            + "3 - add Cargo Car" + SEPARATOR
            + "4 - add Transport" + SEPARATOR;
    public static final String CLIENT_MENU = "Enter request " + SEPARATOR
            + "get count" + SEPARATOR
            + "get transport=(id)" + SEPARATOR;


    private Constants() {

    }
}
