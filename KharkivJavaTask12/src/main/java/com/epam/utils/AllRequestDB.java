package com.epam.utils;

public final class AllRequestDB {

    public static final String SELECT_ALL_USERS = "SELECT * FROM user";
    public static final String INSERT_NEW_USER = "insert into user(name,sur_name,login,password) values (?, ?, ?, ?)";

    private AllRequestDB() {
    }

}
