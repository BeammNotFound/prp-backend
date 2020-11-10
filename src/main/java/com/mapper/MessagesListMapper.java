package com.mapper;

import com.pojo.Messages;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MessagesListMapper {
    Messages allMessages();
    void createMessage(Messages messages);
    Messages fuzzyQueryMessages(Messages messages);

}
