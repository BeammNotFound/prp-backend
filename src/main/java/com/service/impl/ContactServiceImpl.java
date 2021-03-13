package com.service.impl;

import com.common.utils.TimeUtils;
import com.mapper.ContactMapper;
import com.pojo.Contact;
import com.pojo.vo.BaseIdVo;
import com.pojo.vo.CreateContactVo;
import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper mapper;

    @Override
    public void createContact(CreateContactVo contactVo) {
        contactVo.setC_createtime(TimeUtils.getNowTime());
        mapper.createContact(contactVo);
    }

    @Override
    public List<Contact> queryContactByBaseId(BaseIdVo vo) {
        return mapper.queryContactByBaseId(vo);
    }
}
