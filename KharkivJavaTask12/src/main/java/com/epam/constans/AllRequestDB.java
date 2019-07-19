package com.epam.constans;

public final class AllRequestDB {

    public static final String SELECT_ALL_USERS = "SELECT * FROM user";
    public static final String INSERT_NEW_USER = "insert into user(name,sur_name,login,password,image_url) values (?, ?, ?, ?, ?)";
    public static final String SELECT_USER_BY_EMAIL_AND_PASS = "SELECT * FROM user where login=? and password=?";
    public static final String SELECT_ALL_CARS = "SELECT * FROM car limit ?";
    public static final String SELECT_ALL_CLASSES = "select distinct class from car order by class";
    public static final String SELECT_ALL_MARKS = "select distinct mark from car order by mark";
    public static final String SELECT_CARS_BY_CLASS = "SELECT * FROM car WHERE class=?";

    private AllRequestDB() {
    }

}
