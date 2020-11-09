package com.service.impl;

import com.mapper.MessagesListMapper;
import com.pojo.Messages;
import com.service.MessagesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesListImpl implements MessagesListService {
    @Autowired
    MessagesListMapper messagesListMapper;

    @Override
    public Messages allMessages() {
        return messagesListMapper.allMessages();
    }

    @Override
    public void createMessage(Messages messages) {
        messagesListMapper.createMessage(messages);
    }
}
