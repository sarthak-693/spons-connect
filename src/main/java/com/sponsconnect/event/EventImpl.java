package com.sponsconnect.event;

import com.sponsconnect.event.entity.Event;
import com.sponsconnect.event.eventDTO.EventDTO;
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

    @Override
    public Event updateEvent(Long id, EventDTO updateDTO) {
        Optional<Event> optionalEvent = eventRepository.findById(id);

        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();

            if (updateDTO.getTitle() != null) {
                existingEvent.setTitle(updateDTO.getTitle());
            }

            if (updateDTO.getDescription() != null) {
                existingEvent.setDescription(updateDTO.getDescription());
            }

            if (updateDTO.getSponsorshipType() != null) {
                existingEvent.setSponsorshipType(updateDTO.getSponsorshipType());
            }

            if (updateDTO.getBudget() != null) {
                existingEvent.setBudget(updateDTO.getBudget());
            }

            if (updateDTO.getDurationInMonths() != null) {
                existingEvent.setDurationInMonths(updateDTO.getDurationInMonths());
            }

            return eventRepository.save(existingEvent);
        }

        return null;
    }


    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }


    public List<Event> findByParameters(String sponsorshipType, Double budget, Integer durationInMonths) {
        return eventRepository.findBySponsorshipTypeAndBudgetAndDurationInMonths(sponsorshipType, budget, durationInMonths);
    }
}
