package com.sponsconnect.lead.login;


import com.sponsconnect.lead.entity.User;
import com.sponsconnect.lead.service.UserService;
import com.sponsconnect.lead.service.impl.UserServiceImpl;
import com.sponsconnect.lead.userDto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shared.ResponseUtil;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginFacade loginFacade;
    @Autowired
    private LoginService loginService;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);



    @PostMapping("signup")
    public ResponseEntity<ResponseUtil> signUp(@RequestBody UserDTO userDTO){
        ResponseUtil response = null;
        try {

            if (!loginService.isValidPhoneNumber(userDTO.getPhone())) {
                response = new ResponseUtil(false, "Invalid phone number. Please provide a 10-digit phone number.");
                return ResponseEntity.badRequest().body(response);
            }
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
            user.setRole(userDTO.getRole());

            boolean userCreated = loginService.saveUser(user);

            if (userCreated) {
                response = new ResponseUtil(true, "User created successfully");
            }
        }
            catch(Exception e)
        {       log.info("failed to login" + e);
                response = new ResponseUtil(false, "Failed to create user");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<ResponseUtil> login(@RequestBody UserDTO userDTO) {
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







