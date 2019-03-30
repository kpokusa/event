package com.eventcalendar.event.config;

import com.eventcalendar.event.persistance.User;
import com.eventcalendar.event.persistance.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByFirstName(username);
        if (user != null) {
            SecurityUserDetails securityUserDetails = new SecurityUserDetails(user);
            return securityUserDetails;
        } else
            throw new UsernameNotFoundException("no such user!");
    }
}