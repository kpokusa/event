package com.eventcalendar.event.config;

import com.eventcalendar.event.persistance.User;
import com.eventcalendar.event.persistance.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;



@ShellComponent
public class ConfigCommand {


    @Autowired
    UserRepo userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @ShellMethod("Add two names together.")
    public String addAdmin() {
        User user = new User();
        String pass = "rafal";
        user.setFirstName("rafal");
        user.setLastName("rafal");
        user.setEmail("rafal@rafal.pl");
        user.setPassword(bCryptPasswordEncoder.encode(pass));
        user.setRole("ROLE_ADMIN");
        userRepo.save(user);
        return String.format("added admin %s\n with password %s ", user.toString(), pass);
    }

//        @ShellMethod("show registered users")
//        public String showUsers() {
//            List<User> users = IteratorUtils.toList(userRepo.findAll().iterator());
//            StringBuilder stringBuilder = new StringBuilder();
//            for (User user : users) {
//                stringBuilder.append(user.toString());
//            }
//            return stringBuilder.toString();
//
//        }
}

