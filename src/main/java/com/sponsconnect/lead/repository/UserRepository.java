package com.sponsconnect.lead.repository;

import com.sponsconnect.lead.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
