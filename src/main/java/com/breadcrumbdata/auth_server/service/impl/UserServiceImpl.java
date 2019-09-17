package com.breadcrumbdata.auth_server.service.impl;

import com.breadcrumbdata.auth_server.dataobject.User;
import com.breadcrumbdata.auth_server.repository.UserRepository;
import com.breadcrumbdata.auth_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcdPasswordEncoder;

    @Override
    public User create(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(bcdPasswordEncoder.encode(password));
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Override
    public User findOneByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }
}
