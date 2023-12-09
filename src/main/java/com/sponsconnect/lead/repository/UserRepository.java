package com.sponsconnect.lead.repository;

import com.sponsconnect.event.entity.Event;
import com.sponsconnect.lead.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhone(String phone);
}
