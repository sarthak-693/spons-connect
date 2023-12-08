package com.sponsconnect.event.service;

import com.sponsconnect.event.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> getAllEvents();

    Optional<Event> getEventById(Long id);

    Event createEvent(Event event);

    Event updateEvent(Long id, Event updatedEvent);

    void deleteEvent(Long id);
}