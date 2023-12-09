package com.sponsconnect.lead.service;

import com.sponsconnect.lead.entity.User;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Component
public interface UserService {

    User getUserById(Long id);

    void updateUser(User user, Long userid);

    void deleteUser(Long userId);

    List<User> getAllUsers();

}


