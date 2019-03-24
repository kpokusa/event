package com.eventcalendar.event.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("There are no events under this id" + id);
    }
}
