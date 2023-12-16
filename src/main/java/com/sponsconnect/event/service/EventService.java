package com.sponsconnect.event.service;

import com.sponsconnect.event.entity.Event;
import com.sponsconnect.event.eventDTO.EventRequest;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> getAllEvents();

    Optional<Event> getEventById(Long id);

    Event createEvent(EventRequest event);

    Event updateEvent(Long id, EventRequest updateDTO);
    void deleteEvent(Long id);

    List<Event> findByParameters(Double budget, Integer durationInMonths) ;

    List<Object> globalSearch(String pattern);

    }