package com.epam.dao.impl;

import com.epam.dao.UserDao;
import com.epam.entity.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private List<User> userList;

    public UserDaoImpl(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
