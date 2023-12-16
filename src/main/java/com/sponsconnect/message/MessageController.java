package com.sponsconnect.message;

import com.sponsconnect.lead.login.LoginFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sponsconnect.shared.ResponseWrapper;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    private static final Logger log = LoggerFactory.getLogger(LoginFacade.class);


    @PostMapping("/send-email")
    public ResponseEntity<ResponseWrapper> sendEmail(@RequestBody Communicate communicate){
    try {
        boolean sent = this.messageService.sendMessage(communicate);
        return sent ? ResponseEntity.ok(new ResponseWrapper(true, "Message sent")) : ResponseEntity.ok(new ResponseWrapper(false, "Message not sent")) ;
    }
    catch( Exception e){
        log.info("Could not sent message " +  e);
        return ResponseEntity.ok(new ResponseWrapper(false, "Message not sent"));
    }
}
}
