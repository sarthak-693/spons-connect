package com.sponsconnect.shared;


import com.sponsconnect.message.MessageImpl;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Properties;


@Component
public class EmailUtil {

    private static final Logger log = LoggerFactory.getLogger(MessageImpl.class);

    public static boolean sendEmail(String senderEmail, String receiverEmail, String messageText) {
        boolean flag = false;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String username = "";
        String password = "";

        // Session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
            emailMessage.setFrom(new InternetAddress(senderEmail));
            emailMessage.setSubject(Constants.SUBJECT);
            emailMessage.setText(messageText);
            Transport.send(emailMessage);
            flag = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return flag;
    }
}
