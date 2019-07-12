package com.epam.service.impl;

import com.epam.dao.UserDao;
import com.epam.entity.User;
import com.epam.form.RegistrationForm;
import com.epam.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isUserPresent(String login) {
        List<User> users = userDao.getAllUsers();
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getEmail().equals(login))
                .findFirst();
        return userOptional.isPresent();
    }

    @Override
    public Optional<User> addNewUser(HttpServletRequest request) {
        User user = new RegistrationForm().createUserByRequest(request);
        userDao.addNewUser(user);
        return Optional.of(user);
    }
}
