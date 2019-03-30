package com.eventcalendar.event.controller;


import com.eventcalendar.event.exceptions.EventNotFoundException;
import com.eventcalendar.event.persistance.Event;
import com.eventcalendar.event.persistance.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

@GetMapping("/createevents")
    public String showEventForm(Event event){
       return "addevent";
}

@PostMapping("/add")
    public String addEvent(Event event, BindingResult result,Model model){
        if(result.hasErrors()){
            return "addevent";
        }
        eventRepo.save(event);
        model.addAttribute("events", eventRepo.findAll());
        return "display";
}

}