package com.service.impl;

import com.mapper.PetsMapper;
import com.pojo.PetsInfo;
import com.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsServiceImpl implements PetsService {

    @Autowired
    private PetsMapper petsMapper;

    @Override
    public List<PetsInfo> queryPetsInfoByBaseId(Integer base_id) {
        return petsMapper.queryPetsInfoByBaseId(base_id);
    }
}
