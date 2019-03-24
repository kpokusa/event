package com.eventcalendar.event.persistance;

import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, Long> {
    //List<Event> findByEvent_name (String event_name);
}
