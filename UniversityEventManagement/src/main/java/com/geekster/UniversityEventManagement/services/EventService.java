package com.geekster.UniversityEventManagement.services;

import com.geekster.UniversityEventManagement.models.EventModel;
import com.geekster.UniversityEventManagement.repository.IEventRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class EventService {
    @Autowired
    IEventRepo iEventRepo;

    public String addEvent(ArrayList<EventModel> eventList) {
    Iterable<EventModel>addStatus=iEventRepo.saveAll(eventList);
    if(eventList!=null){
        return "event added successfully";
    }else{
        return "event not added successfully";
      }
    }

    @Transactional
    public void updateEvent(EventModel eventList) {
        iEventRepo.updateEventDetails(eventList.getEventId(),eventList.getEventName(),eventList.getLocationOfEvent(),eventList.getDate(),eventList.getStartTime(),eventList.getEndTime());
    }

    public ArrayList<EventModel> getAllEventByDate(LocalDate date) {
        return iEventRepo.findByDate(date);
    }

    public void deleteEventById(int id) {
        iEventRepo.deleteById(id);
    }
}
