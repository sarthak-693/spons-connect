package com.sponsconnect.lead.login;


import com.sponsconnect.lead.entity.User;
import com.sponsconnect.lead.service.impl.UserServiceImpl;
//import com.sponsconnect.lead.userDto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shared.ResponseUtil;

import javax.validation.Valid;


@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginFacade loginFacade;
    private final LoginService loginService;


    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    public LoginController(LoginFacade loginFacade, LoginService loginService) {
        this.loginFacade = loginFacade;
        this.loginService = loginService;
    }

    @PostMapping("signup")
    public ResponseEntity<ResponseUtil> signUp(@Valid @RequestBody User userDTO, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.ok(new ResponseUtil(false, "Validation error"));
            }

            boolean userCreated = loginService.saveUser(userDTO);

            return ResponseEntity.ok(new ResponseUtil(userCreated, userCreated ? "User created successfully" : "Failed to create user"));
        } catch (Exception e) {
            log.error("Failed to create user", e);
            return ResponseEntity.ok(new ResponseUtil(false, "Failed to create user"));
        }
    }


    @PostMapping("")
    public ResponseEntity<ResponseUtil> login(@RequestBody User userDTO) {
        ResponseUtil response;
        try {
           this.loginFacade.login(userDTO);

           response = new ResponseUtil(true, "login successful");

        } catch (Exception e) {
            log.error("Failed to login: " + e.getMessage(), e);
            response = new ResponseUtil(false, "Failed to perform login");
        }
        return ResponseEntity.ok(response);
    }


}







