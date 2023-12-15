package com.sponsconnect.lead.service;

import com.sponsconnect.lead.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getUserById(Long id);

    void updateUser(User user, Long userid);

    void deleteUser(Long userId);

    List<User> getAllUsers();

}


