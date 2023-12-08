package com.sponsconnect.lead.service;

import com.sponsconnect.lead.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    void saveUser(User user);

    void updateUser(User user, Long userid);

    void deleteUseryId(Long userId);

    List<User> getAllUsers();

}
