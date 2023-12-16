package com.sponsconnect.message;


import com.sponsconnect.lead.entity.User;
import com.sponsconnect.lead.repository.UserRepository;
import com.sponsconnect.shared.EmailUtil;
import com.sponsconnect.userProfile.UserProfileRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Properties;

@Component
@Transactional
public class MessageImpl implements MessageService {

    private final MessageRepo messageRepo;
    private final UserRepository userRepo;

    private final UserProfileRepo userProfile;

    @Autowired
    public MessageImpl(MessageRepo messageRepo, UserRepository userRepo,UserProfileRepo userProfile) {
        this.messageRepo = messageRepo;
        this.userRepo = userRepo;
        this.userProfile = userProfile;
    }

    private static final Logger log = LoggerFactory.getLogger(MessageImpl.class);

    public boolean sendMessage(Communicate communicateDto) {
        log.info("inside sendMessage");

        try {
            User senderUser = getUserByIdOrThrow(communicateDto.getSender().getId(), "Sender");
            User receiverUser = getUserByIdOrThrow(communicateDto.getReceiver().getId(), "Receiver");

            String senderEmail = senderUser.getEmail();
            String receiverEmail = receiverUser.getEmail();

            if (EmailUtil.sendEmail(senderEmail, receiverEmail, communicateDto.getContent())) {
                Communicate communicate = new Communicate();
                communicate.setSender(communicateDto.getSender());
                communicate.setReceiver(communicateDto.getReceiver());
                communicate.setContent(communicateDto.getContent());

                messageRepo.save(communicate);

                log.info("Message sent");
                return true;
            }
        } catch (NoSuchElementException e) {
            log.error("Error sending message: " + e.getMessage());
        }

        return false;
    }

    private User getUserByIdOrThrow(Long userId, String userType) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new NoSuchElementException(userType + " not found with ID: " + userId));
    }


}
