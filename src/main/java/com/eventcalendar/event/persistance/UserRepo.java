package com.eventcalendar.event.persistance;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {


    User findUserByFirstName(String username);
}
