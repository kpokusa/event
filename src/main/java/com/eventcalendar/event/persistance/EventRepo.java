package com.eventcalendar.event.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("eventRepo")
public interface EventRepo extends CrudRepository<Event, Long> {

}
