package com.service.impl;

import com.mapper.PopularizationsMapper;
import com.pojo.Popularizations;
import com.service.PopularizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopularizationsServiceImpl implements PopularizationsService {

    @Autowired
    PopularizationsMapper mapper;

    @Override
    public Popularizations queryPopularizations() {
        return mapper.queryPopularizationsList();
    }

    @Override
    public void createPopularization(Popularizations popularizations) {
        mapper.createPopularization(popularizations);
    }
}
