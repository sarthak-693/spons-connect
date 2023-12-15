//package com.sponsconnect.lead.userDto;
//
//import com.sponsconnect.lead.entity.UserRole;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//
//public class UserDTO {
//    @NotBlank(message = "Username cannot be blank")
//    @Size(min =5, max = 50, message = "Name must be between 5 and 50 characters")
//    private String username;
//    private String email;
//    private String phone;
//    private UserRole role;
//
//    private String password;
//
//
//    public String getPassword() {
//        return password;
//    }
//
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public UserRole getRole() {
//        return role;
//    }
//
//    public void setRole(UserRole role) {
//        this.role = role;
//    }
//
//    public UserDTO(String username, String email, String phone, UserRole role) {
//        this.username = username;
//        this.email = email;
//        this.phone = phone;
//        this.role = role;
//    }
//}
