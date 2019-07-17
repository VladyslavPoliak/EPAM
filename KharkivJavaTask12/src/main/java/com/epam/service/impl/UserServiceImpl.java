package com.epam.service.impl;

import com.epam.dao.UserDao;
import com.epam.entity.User;
import com.epam.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isUserExists(String login) {
        List<User> users = userDao.getAllUsers();
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getEmail().equals(login))
                .findFirst();
        return userOptional.isPresent();
    }

    @Override
    public void addNewUser(User user) {
        userDao.addNewUser(user);
    }

    @Override
    public Optional<User> getUserByEmailAndPass(String login, String pass) {
        User user = userDao.getUserByEmailAndPass(login, pass);
        return Optional.of(user);
    }

}
