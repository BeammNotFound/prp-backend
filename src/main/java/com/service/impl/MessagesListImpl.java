package com.service.impl;

import com.mapper.MessagesListMapper;
import com.pojo.Messages;
import com.pojo.Popularizations;
import com.service.MessagesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesListImpl implements MessagesListService {
    @Autowired
    private MessagesListMapper messagesListMapper;

    @Override
    public List<Messages> allMessages() {
        return messagesListMapper.allMessages();
    }

    @Override
    public void createMessage(Messages messages) {
        messagesListMapper.createMessage(messages);
    }

    @Override
    public List<Messages> fuzzyQueryMessages(Messages messages) {
        return messagesListMapper.fuzzyQueryMessages(messages);
    }

    @Override
    public void deleteMessageById(Messages messages) {
        messagesListMapper.deleteMessageById(messages);
    }
}
