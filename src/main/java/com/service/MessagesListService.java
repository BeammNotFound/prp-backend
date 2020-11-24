package com.service;

import com.pojo.Messages;

import java.util.List;

public interface MessagesListService {
    List<Messages> allMessages();
    void createMessage(Messages messages);
    List<Messages> fuzzyQueryMessages(Messages messages);
    void deleteMessageById(Messages messages);
}
