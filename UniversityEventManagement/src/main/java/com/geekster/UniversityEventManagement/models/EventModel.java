package com.geekster.UniversityEventManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class EventModel {
    @Column(name = "event_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eventId;
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_location")
    private String locationOfEvent;
    @Column(name = "event_date")
    private LocalDate date;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name = "end_time")
    private Time endTime;

}
