package com.service.impl;

import com.common.api.CommonResult;
import com.common.utils.RedisUtil;
import com.mapper.MessagesListMapper;
import com.pojo.Messages;
import com.service.MessagesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesListImpl implements MessagesListService {
    @Autowired
    private MessagesListMapper messagesListMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Object allMessages() {
        if (redisUtil.hasKey("allMessages"))
            return redisUtil.get("allMessages");
        else
            redisUtil.set("allMessages", messagesListMapper.allMessages(), 0);
            return redisUtil.get("allMessages");
    }

    @Override
    public void createMessage(Messages messages) {

        messagesListMapper.createMessage(messages);
        redisUtil.set("allMessages", messagesListMapper.allMessages());
    }

    @Override
    public List<Messages> fuzzyQueryMessages(Messages messages) {
        return messagesListMapper.fuzzyQueryMessages(messages);
    }

    @Override
    public void deleteMessageById(Messages messages) {
        if (redisUtil.hasKey("allMessages"))
            redisUtil.del("allMessages");
        messagesListMapper.deleteMessageById(messages);
    }
}
