package com.eventcalendar.event.service;

import com.eventcalendar.event.persistance.User;
import com.eventcalendar.event.persistance.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public User findByConfirmationToken(String confirmationToken) {
        return userRepo.findByConfirmationToken(confirmationToken);
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

}
