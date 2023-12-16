package com.sponsconnect.shared;

import org.springframework.stereotype.Component;

@Component
public class Constants {

    public static final String MESSAGE = "Hi , I want to connect with you to talk about the sponsorship details";

    public static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";


    public static final String SUBJECT = "INFORMATION ABOUT SPONSOSHIP";
}
