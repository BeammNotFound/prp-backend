package com.service.impl;

import com.mapper.BasesMapper;
import com.pojo.Bases;
import com.service.BasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasesServiceImpl implements BasesService {

    @Autowired
    BasesMapper basesMapper;

    @Override
    public Bases queryBases() {
        return basesMapper.queryBases();
    }
}
