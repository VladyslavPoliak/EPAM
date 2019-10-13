package com.spring.service;

import com.spring.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User findByUsername(String login);

    void save(User user);
}
