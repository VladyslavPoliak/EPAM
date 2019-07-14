package com.epam.dao;

import com.epam.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void addNewUser(User user);

    User getUserByEmailAndPass(String login, String pass);
}
