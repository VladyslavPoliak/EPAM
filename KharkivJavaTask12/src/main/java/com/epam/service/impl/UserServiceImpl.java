package com.epam.service.impl;

import com.epam.dao.UserDao;
import com.epam.database.DataBaseManager;
import com.epam.entity.User;
import com.epam.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private DataBaseManager dataBaseManager;

    public UserServiceImpl(UserDao userDao, DataBaseManager dataBaseManager) {
        this.userDao = userDao;
        this.dataBaseManager = dataBaseManager;
    }

    @Override
    public boolean isUserPresent(String login) {
        List<User> users = userDao.getAllUsers();
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getEmail().equals(login))
                .findFirst();
        return userOptional.isPresent();
    }
}
