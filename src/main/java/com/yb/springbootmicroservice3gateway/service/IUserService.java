package com.yb.springbootmicroservice3gateway.service;

import com.yb.springbootmicroservice3gateway.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUser(String username);

    List<User> findAllUsers();
}
