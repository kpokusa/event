package com.eventcalendar.event.controller;


import com.eventcalendar.event.exceptions.EventNotFoundException;
import com.eventcalendar.event.persistance.Event;
import com.eventcalendar.event.persistance.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class EventController {


    @Autowired
    private EventRepo eventRepo;


    @GetMapping("/events")
    List<Event> all() {
        return (List<Event>) eventRepo.findAll();
    }

   /* @RequestMapping(value="/events", method = RequestMethod.GET)
    List<Event> all(Model model) {
        model.addAttribute("list", eventRepo.findAll());
        return (List<Event>) eventRepo;
    }
*/
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

    @RequestMapping(value = "events2", method = RequestMethod.GET)
    public List<Event> messages(Model model) {
        model.addAttribute("messages", eventRepo.findAll());
        return (List<Event>) eventRepo.findAll();
    }


}