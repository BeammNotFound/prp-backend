package com.mapper;


import com.pojo.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ContactMapper {
    void createContact(Contact contact);
}
