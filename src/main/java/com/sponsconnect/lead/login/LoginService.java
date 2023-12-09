package com.sponsconnect.lead.login;

import com.sponsconnect.lead.entity.User;
import com.sponsconnect.lead.userDto.UserDTO;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
@Component
public interface LoginService {

    boolean login(UserDTO UserDTO) throws NoSuchAlgorithmException;

    boolean saveUser(User user) throws NoSuchAlgorithmException;

    boolean isValidPhoneNumber(String phone);
}
