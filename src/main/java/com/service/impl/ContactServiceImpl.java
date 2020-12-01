package com.service.impl;

import com.common.utils.TimeUtils;
import com.mapper.ContactMapper;
import com.pojo.vo.CreateContactVo;
import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper mapper;

    @Override
    public void createContact(CreateContactVo contactVo) {
        contactVo.setC_createtime(TimeUtils.getNowTime());
        mapper.createContact(contactVo);
    }
}
