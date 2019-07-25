package com.epam.constans;

public final class SqlQueries {

    public static final String SELECT_ALL_USERS = "SELECT * FROM user";
    public static final String INSERT_NEW_USER = "INSERT INTO user(name,sur_name,login,password,image_url) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_USER_BY_EMAIL_AND_PASS = "SELECT * FROM user WHERE login=? and password=?";
    public static final String SELECT_ALL_CARS = "SELECT * FROM car limit ? offset ?";
    public static final String SELECT_ALL_CLASSES = "SELECT DISTINCT class from car ORDER BY class";
    public static final String SELECT_ALL_MARKS = "SELECT DISTINCT mark from car ORDER BY mark";
    public static final String SELECT_CARS_BY_CLASS = "SELECT * FROM car WHERE class=?";
    public static final String SELECT_ALL_CARS_COUNT = "SELECT COUNT(*) FROM car";
    public static final String SELECT_CAR_BY_ID = "SELECT * FROM car WHERE id_car=?";

    public static final String CREATE_NEW_ORDER = "INSERT INTO `order`(id_account,created,order_status,status_description) values (?,?,?,?)";
    public static final String GET_DATA_NEW_ORDER = "SELECT * FROM `order` where id=?";
    public static final String CREATE_NEW_ORDER_ITEM = "INSERT INTO order_item(id_order,id_car,days) values (?,?,?)";

    private SqlQueries() {
    }

}
