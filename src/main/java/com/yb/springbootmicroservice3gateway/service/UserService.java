package com.yb.springbootmicroservice3gateway.service;

import com.yb.springbootmicroservice3gateway.model.User;
import com.yb.springbootmicroservice3gateway.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
