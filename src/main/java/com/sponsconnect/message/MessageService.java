package com.sponsconnect.message;

import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    public boolean sendMessage(Communicate communicate);
}
