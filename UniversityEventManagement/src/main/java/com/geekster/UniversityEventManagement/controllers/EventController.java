package com.geekster.UniversityEventManagement.controllers;

import com.geekster.UniversityEventManagement.models.EventModel;
import com.geekster.UniversityEventManagement.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping("/addEvent")
    public String addEvent(@RequestBody ArrayList<EventModel>eventList){
        return eventService.addEvent(eventList);
    }
    @GetMapping("/getAllEventByDate/{date}")
    public ArrayList<EventModel>getAllEventByDate(@PathVariable LocalDate date){
       return  eventService.getAllEventByDate(date);
    }

    @PutMapping("/updateEvent")
    public void updateEvent(@RequestBody EventModel eventList){
        eventService.updateEvent(eventList);
    }
    @DeleteMapping("/deleteEvent/{id}")
 public void deleteEvent(@PathVariable int id){
        eventService.deleteEventById(id);
    }
}
