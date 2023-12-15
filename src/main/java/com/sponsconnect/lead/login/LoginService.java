package com.sponsconnect.lead.login;

import com.sponsconnect.lead.entity.User;
//import com.sponsconnect.lead.userDto.UserDTO;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
@Component
public interface LoginService {

    boolean login(User UserDTO) throws NoSuchAlgorithmException;

    boolean saveUser(User userDTO) throws NoSuchAlgorithmException;
}
