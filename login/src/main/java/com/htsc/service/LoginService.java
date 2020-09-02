package com.htsc.service;

import com.htsc.repository.User;
import com.htsc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username).orElse(null);
        if(user == null)
            return false;
        return password.equals(user.getPassword());
    }

    public boolean register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return true;
    }
}
