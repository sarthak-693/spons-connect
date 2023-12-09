package com.sponsconnect.lead.service.impl;

import com.sponsconnect.lead.entity.User;
import com.sponsconnect.lead.login.LoginService;
import com.sponsconnect.lead.repository.UserRepository;
import com.sponsconnect.lead.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public abstract class UserServiceImpl implements UserService, LoginService {

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


    public boolean saveUser(User user, String hashedPassword, String salt) throws NoSuchAlgorithmException {
        log.info("inside saveUser");
        try {
            user.setPasswordHash(hashedPassword);
            user.setSalt(salt);
            userRepository.save(user);
            return true;
        }
        catch (Exception e) {
            LoggerFactory.getLogger(UserServiceImpl.class).error("Error saving user", e);
            return false;

        }
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
    public void deleteUser(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isPresent()){
            User userDetail = userOpt.get();
            userDetail.setDelete(true);
            userRepository.save(userDetail);}
        else
            throw new RuntimeException("user not found.");
    }
}
