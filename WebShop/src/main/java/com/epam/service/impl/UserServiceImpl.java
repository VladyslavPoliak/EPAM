package com.epam.service.impl;

import com.epam.entity.User;
import com.epam.repository.UserRepository;
import com.epam.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isUserExists(String login) {
        List<User> users = userRepository.getAllUsers();
        Optional<User> userOptional = users.stream()
                .filter(user -> user.getEmail().equals(login))
                .findFirst();
        return userOptional.isPresent();
    }

    @Override
    public void addNewUser(User user) {
        userRepository.addNewUser(user);
    }

    @Override
    public Optional<User> getUserByEmailAndPass(String login, String pass) {
        User user = userRepository.getUserByEmailAndPass(login, pass);
        return Optional.of(user);
    }

}
