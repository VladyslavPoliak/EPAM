package com.epam.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -704339391151912099L;
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;

    private String imageUrl;
    private String  role;

    private User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.password = builder.password;
        this.email = builder.email;
        this.imageUrl = builder.imageUrl;
        this.role=builder.role;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public int getId() {
        return id;
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String  getRole() {
        return role;
    }

    public static class UserBuilder {

        private int id;
        private String name;
        private String surname;
        private String password;
        private String email;

        private String imageUrl;
        private String role;

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

        public UserBuilder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }
        public UserBuilder setRole(String role){
            this.role=role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}