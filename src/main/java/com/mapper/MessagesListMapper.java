package com.mapper;

import com.pojo.Messages;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessagesListMapper {
    List<Messages> allMessages();
    void createMessage(Messages messages);
    List<Messages> fuzzyQueryMessages(Messages messages);
    void deleteMessageById(Messages messages);
}
