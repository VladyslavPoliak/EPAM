package com.epam.container;

import com.epam.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserContainer {

    private User user;
    private User user2;
    private User user3;

    private List<User> userList = new ArrayList<>();

    public UserContainer() {
        createUsers();
        fillingList();
    }

    public List<User> getUserList() {
        return userList;
    }

    private void fillingList() {
        userList.add(user3);
        userList.add(user2);
        userList.add(user);
    }

    private void createUsers() {
        user = new User.UserBuilder()
                .setName("user")
                .setSurname("test")
                .setEmail("test@google.com")
                .setPassword("pass")
                .build();

        user2 = new User.UserBuilder()
                .setName("user2")
                .setSurname("test2")
                .setEmail("test2@google.com")
                .setPassword("pass2")
                .build();

        user3 = new User.UserBuilder()
                .setName("user3")
                .setSurname("test3")
                .setEmail("test3@google.com")
                .setPassword("pass3")
                .build();
    }
}
