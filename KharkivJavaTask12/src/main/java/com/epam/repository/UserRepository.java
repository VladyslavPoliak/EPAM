package com.epam.repository;

import com.epam.entity.User;

import java.util.List;

public interface UserRepository {

    void addNewUser(User user);

    User getUserByEmailAndPass(String login, String pass);

    List<User> getAllUsers();
}
