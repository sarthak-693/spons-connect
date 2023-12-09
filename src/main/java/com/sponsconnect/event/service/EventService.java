package com.sponsconnect.event.service;

import com.sponsconnect.event.entity.Event;
import com.sponsconnect.event.eventDTO.EventDTO;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> getAllEvents();

    Optional<Event> getEventById(Long id);

    Event createEvent(Event event);

    Event updateEvent(Long id, EventDTO updateDTO);
    void deleteEvent(Long id);

    List<Event> findByParameters(String sponsorshipType, Double budget, Integer durationInMonths) ;

    }