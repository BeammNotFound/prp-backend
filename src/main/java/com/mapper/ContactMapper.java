package com.mapper;


import com.pojo.Contact;
import com.pojo.vo.BaseIdVo;
import com.pojo.vo.CreateContactVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ContactMapper {
    void createContact(CreateContactVo contactVo);
    List<Contact> queryContactByBaseId(BaseIdVo vo);

}
