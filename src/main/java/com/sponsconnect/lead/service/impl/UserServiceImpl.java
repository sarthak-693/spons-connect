package com.sponsconnect.lead.service.impl;

import com.sponsconnect.lead.entity.User;
import com.sponsconnect.lead.repository.UserRepository;
import com.sponsconnect.lead.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        log.info("inside getUserById "+ id);
        Optional<User> userOpt = userRepository.findById(id);
        if(userOpt.isPresent())
            return userOpt.get();
        else
            throw new RuntimeException("user not found.");
    }

    @Override
    public void saveUser(User user) {
        log.info("inside saveUser ");

        User userDetail = userRepository.save(user);
        System.out.println("user saved to db with userId : " + userDetail.getId());
    }

    @Override
    public List<User> getAllUsers() {
        log.info("inside getAllUsers ");

        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user, Long userId) {
        log.info("inside updateUser ");

        Optional<User> userDetailOpt = userRepository.findById(userId);
        if (userDetailOpt.isPresent()) {
            User userDetail = userDetailOpt.get();

            // Check and update each field individually
            if (user.getUsername() != null && !user.getUsername().isEmpty()) {
                userDetail.setUsername(user.getUsername());
            }


            if (user.getEmail() != null && !user.getEmail().isEmpty()) {
                userDetail.setEmail(user.getEmail());
            }

            if (user.getPhone() != null && !user.getPhone().isEmpty()) {
                userDetail.setPhone(user.getPhone());
            }

            if (user.getRole() != null) {
                userDetail.setRole(user.getRole());
            }

            userRepository.save(userDetail);
        } else {
            throw new RuntimeException("User not found.");
        }
    }


    @Override
    public void deleteUseryId(Long userId) {

        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isPresent())
            userRepository.deleteById(userId);
        else
            throw new RuntimeException("user not found.");
    }
}
