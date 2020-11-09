package com.service;

import com.pojo.Messages;

public interface MessagesListService {
    Messages allMessages();
    void createMessage(Messages messages);
}
