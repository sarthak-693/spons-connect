package com.sponsconnect.event;

import com.sponsconnect.event.entity.Event;
import com.sponsconnect.event.repository.EventRepo;
import com.sponsconnect.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventImpl implements EventService {

    @Autowired
    private EventRepo eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        if (eventRepository.existsById(id)) {
            updatedEvent.setId(id);
            return eventRepository.save(updatedEvent);
        }
        return null; // Handle not found scenario
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
