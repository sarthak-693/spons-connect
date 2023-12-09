package com.sponsconnect.lead.service;

import com.sponsconnect.lead.entity.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {

    User getUserById(Long id);

    void updateUser(User user, Long userid);

    void deleteUser(Long userId);

    List<User> getAllUsers();

}


