package com.geekster.UniversityEventManagement.repository;

import com.geekster.UniversityEventManagement.models.EventModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public interface IEventRepo extends CrudRepository<EventModel,Integer> {
  public
  @Modifying
  @Query(value = "update EVENT_MODEL set EVENT_ID = :eventId , EVENT_NAME = :eventName , EVENT_LOCATION = :locationOfEvent,EVENT_DATE = :date , EVENT_START_TIME = :startTime , EVENT_END_TIME = :endTime where EVENT_ID = :eventId",  nativeQuery = true)
  void updateEventDetails(Integer eventId, String eventName, String locationOfEvent,LocalDate date, Time startTime, Time endTime);

 public ArrayList<EventModel> findByDate(LocalDate date);
}
