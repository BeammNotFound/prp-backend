package com.service.impl;

import com.common.utils.TimeUtils;
import com.mapper.PetsMapper;
import com.mapper.UserMapper;
import com.pojo.AdoptionPats;
import com.pojo.PetsInfo;
import com.service.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsServiceImpl implements PetsService {

    @Autowired
    private PetsMapper petsMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<PetsInfo> queryPetsInfoByBaseId(Integer base_id) {
        return petsMapper.queryPetsInfoByBaseId(base_id);
    }

    @Override
    public Boolean adoptPet(AdoptionPats adoptionPats) {
        if (userMapper.queryUserById(adoptionPats.getUser_id()) == null) {
            return false;
        }
        adoptionPats.setAp_application_time(TimeUtils.getNowTime());
        adoptionPats.setAp_status(2);
        petsMapper.adoptPet(adoptionPats);
        return true;
    }

    @Override
    public List<PetsInfo> queryAdoptPet(Integer user_id) {
        return petsMapper.queryAdoptPet(user_id);
    }
}