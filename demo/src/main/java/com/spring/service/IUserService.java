package com.spring.service;

import com.spring.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User findByLogin(String login);

    void save(User user);
}
