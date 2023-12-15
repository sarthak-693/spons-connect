package com.sponsconnect.lead.login;

import com.sponsconnect.lead.entity.User;
import com.sponsconnect.lead.repository.UserRepository;
import com.sponsconnect.lead.service.impl.UserServiceImpl;
//import com.sponsconnect.lead.userDto.UserDTO;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import shared.ResponseUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


@Component
public class LoginFacade implements LoginService{

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private UserRepository userRepo;

    private static final Logger log = LoggerFactory.getLogger(LoginFacade.class);

    @Override
    public boolean login(User userDTO) throws NoSuchAlgorithmException {
        log.info("inside login");
        String identifier = userDTO.getPhone();

        User user = userRepo.findByPhone(identifier);

        if (user != null) {
            String hashedPassword = hashPassword(userDTO.getPassword(), user.getSalt());
            return hashedPassword.equals(user.getPasswordHash());
        }
        return false;

    }

    public static String generateSalt() {
        log.info("inside generateSalt");
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);

        return Base64.getEncoder().encodeToString(salt);
    }




    private String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String passwordWithSalt = password + salt;
        byte[] hashedBytes = md.digest(passwordWithSalt.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte hashedByte : hashedBytes) {
            sb.append(Integer.toString((hashedByte & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }



    public boolean saveUser(User userDTO) throws NoSuchAlgorithmException {
        log.info("inside saveUser");
        if (isValidPhoneNumber(userDTO.getPhone())) {
            return false;
        }

        String salt = generateSalt();

        String hashedPassword = hashPassword(userDTO.getPassword(), salt);

        return userServiceImpl.saveUser(userDTO, hashedPassword, salt);

    }

    private boolean isValidPhoneNumber(String phone){
        return phone.length() == 10;
    }

}
