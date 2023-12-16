package com.sponsconnect.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sponsconnect.event.entity.Event;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EventRepo extends JpaRepository<Event, Long> {

    List<Event> findByAndBudgetAndDurationInMonths(
             Double budget, Integer durationInMonths
    );

    List<Event> findByTitleContainingOrLocationContaining(String title, String location);


}
