package com.epam.utils;

public final class AllRequestDB {

    public static final String SELECT_ALL_USERS = "SELECT * FROM user";
    public static final String INSERT_NEW_USER = "insert into user(name,sur_name,login,password) values (?, ?, ?, ?)";
    public static final String SELECT_USER_BY_EMAIL_AND_PASS = "SELECT * FROM user where login=? and password=?";

    private AllRequestDB() {
    }

}
