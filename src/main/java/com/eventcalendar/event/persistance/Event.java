package com.eventcalendar.event.persistance;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id", nullable = false)
    private Long id;

    private String event_name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate event_date;

    private String event_description;
    private String event_city;


    public Event(String event_name, LocalDate event_date, String event_description, String event_city) {
        this.event_name = event_name;
        this.event_date = event_date;
        this.event_description = event_description;
        this.event_city = event_city;
    }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getEvent_name() {

        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {

        this.event_date = event_date;
    }

    public String getEvent_description() {

        return event_description;
    }

    public void setEvent_description(String event_description) {

        this.event_description = event_description;
    }

    public String getEvent_city() {
        return event_city;
    }

    public void setEvent_city(String event_city) {
        this.event_city = event_city;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", event_name='" + event_name + '\'' +
                ", event_date=" + event_date +
                ", event_description='" + event_description + '\'' +
                ", event_city='" + event_city + '\'' +
                '}';
    }
}
