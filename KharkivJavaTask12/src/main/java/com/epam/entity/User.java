package com.epam.entity;

import com.epam.model.CurrentAccount;

public class User implements CurrentAccount {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;

    private User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.password = builder.password;
        this.email = builder.email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return name + " (" + email + ")";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public static class UserBuilder {

        private int id;
        private String name;
        private String surname;
        private String password;
        private String email;

        public UserBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}