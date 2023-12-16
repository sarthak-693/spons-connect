package com.sponsconnect.event;

import com.sponsconnect.event.entity.Event;
import com.sponsconnect.event.eventDTO.EventRequest;
import com.sponsconnect.event.repository.EventRepo;
import com.sponsconnect.event.service.EventService;
import com.sponsconnect.userProfile.UserProfile;
import com.sponsconnect.userProfile.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventImpl implements EventService {

    @Autowired
    private final EventRepo eventRepository;
    private final UserProfileRepo userProfileRepo;

    public EventImpl( EventRepo eventRepository,UserProfileRepo userProfileRepo){
        this.eventRepository= eventRepository;
        this.userProfileRepo= userProfileRepo;
    }



    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }
@Override
    public Event createEvent(EventRequest event) throws  EntityNotFoundException {

    UserProfile seeker = userProfileRepo.findById(event.getSeekerId())
            .orElseThrow(() -> new EntityNotFoundException("UserProfile not found"));

        Event events = new Event();
        events.setSeeker(seeker);
        events.setLocation(event.getLocation());
        events.setSeeker(seeker);
        events.setBudget(event.getBudget());
        events.setTitle(event.getTitle());
        events.setDescription(event.getDescription());
        events.setDurationInMonths(event.getDurationInMonths());
        event.setStatus(event.getStatus());

        return eventRepository.save(events);
    }

    @Override
    public Event updateEvent(Long id, EventRequest updateDTO) {
        Optional<Event> optionalEvent = eventRepository.findById(id);

        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();

            if (updateDTO.getTitle() != null) {
                existingEvent.setTitle(updateDTO.getTitle());
            }

            if (updateDTO.getDescription() != null) {
                existingEvent.setDescription(updateDTO.getDescription());
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


@Override
    public List<Event> findByParameters(Double budget, Integer durationInMonths) {
        return eventRepository.findByAndBudgetAndDurationInMonths(budget, durationInMonths);
    }

    @Override
    public List<Object> globalSearch(String pattern) {
        List<Object> searchResult = new ArrayList<>();
        List<UserProfile> users = userProfileRepo.findByInstitutionNameContaining(pattern);
        List<Event> events = eventRepository.findByTitleContainingOrLocationContaining(pattern, pattern);
        searchResult.addAll(users);
        searchResult.addAll(events);
        return searchResult;
    }
}
