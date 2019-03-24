package com.eventcalendar.event.controller;


import com.eventcalendar.event.exceptions.EventNotFoundException;
import com.eventcalendar.event.persistance.Event;
import com.eventcalendar.event.persistance.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/main")
public class EventController {


    @Autowired
    private EventRepo eventRepo;



    @GetMapping(value = "/events")
    public String events(Model model) {

        Iterable<Event> events = eventRepo.findAll();
        model.addAttribute("events", events);

        return "display";
    }
        @PostMapping("/addevents")
    Event newEvent(@RequestBody Event newEvent) {

        return eventRepo.save(newEvent);
    }



    @GetMapping("/events/{id}")
    Event singleEvent(@PathVariable Long id) /*throws EventNotFoundException*/ {

        return eventRepo.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    @PutMapping("/events/{id}")
    Event replaceEvent(@RequestBody Event newEvent, @PathVariable Long id) {
        return eventRepo.findById(id)
                .map(event -> {
                    event.setEvent_name(newEvent.getEvent_name());
                    event.setEvent_description(newEvent.getEvent_description());
                    event.setEvent_city(newEvent.getEvent_city());
                    event.setEvent_date(newEvent.getEvent_date());
                    return eventRepo.save(event);
                })
                .orElseGet(() -> {
                    newEvent.setId(id);
                    return eventRepo.save(newEvent);
                });
    }

    @DeleteMapping("/events/{id}")
    void deleteEvent(@PathVariable Long id) {
        eventRepo.deleteById(id);
    }




}