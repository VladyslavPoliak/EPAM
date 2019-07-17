package com.epam.service;

import com.epam.entity.User;

import java.util.Optional;

public interface UserService {

    boolean isUserExists(String login);

    void addNewUser(User user);

    Optional<User> getUserByEmailAndPass(String login, String pass);

}
