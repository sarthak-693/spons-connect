package com.sponsconnect.event.controller;

import com.sponsconnect.event.entity.Event;
import com.sponsconnect.event.eventDTO.EventRequest;
import com.sponsconnect.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody EventRequest event) {
        Event createdEvent = eventService.createEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody EventRequest updatedEvent) {
        Event event = eventService.updateEvent(id, updatedEvent);
        return event != null ? new ResponseEntity<>(event, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/api/events")
    public List<Event> getEventsByParameters(
            @RequestParam(required = false) String sponsorshipType,
            @RequestParam(required = false) Double budget,
            @RequestParam(required = false) Integer durationInMonths) {
        return eventService.findByParameters( budget, durationInMonths);
    }


    @GetMapping("global-search")
    public ResponseEntity<List<Object>> globalSearch(@RequestBody String pattern){
        List<Object> searchResults;
        try{
            searchResults = eventService.globalSearch(pattern);
        }
        catch(Exception e){
            e.getStackTrace();
            searchResults = null;
        }
        return ResponseEntity.ok(searchResults);

    }
}
