package com.service;

import com.pojo.Contact;
import com.pojo.vo.BaseIdVo;
import com.pojo.vo.CreateContactVo;

import java.util.List;

public interface ContactService {
    void createContact(CreateContactVo contactVo);

    List<Contact> queryContactByBaseId(BaseIdVo vo);

}
