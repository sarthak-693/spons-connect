package com.sponsconnect.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sponsconnect.event.entity.Event;


public interface EventRepo extends JpaRepository<Event, Long> {

}
