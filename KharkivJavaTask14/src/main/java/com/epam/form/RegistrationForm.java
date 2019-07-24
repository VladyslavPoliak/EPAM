package com.epam.form;

import com.epam.entity.User;

import javax.servlet.http.HttpServletRequest;

public class RegistrationForm {

    public User createUserByRequest(HttpServletRequest request) {
        return new User.UserBuilder().setName(request.getParameter("userName"))
                .setSurname(request.getParameter("userSurname"))
                .setPassword(request.getParameter("userPassword"))
                .setEmail(request.getParameter("userEmail"))
                .build();
    }


}
