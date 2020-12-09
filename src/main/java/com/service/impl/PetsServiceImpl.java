package com.service.impl;

import com.common.utils.RedisUtil;
import com.common.utils.TimeUtils;
import com.mapper.PetsMapper;
import com.mapper.UserMapper;
import com.pojo.AdoptionPats;
import com.pojo.AdoptionForm;
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

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<PetsInfo> queryPetsInfoByBaseId(Integer base_id) {
        return petsMapper.queryPetsInfoByBaseId(base_id);
    }

    @Override
    public Object queryAllPetsInfo() {
        if (redisUtil.hasKey("allPetsInfo"))
            return redisUtil.get("allPetsInfo");
        else
            redisUtil.set("allPetsInfo", petsMapper.queryAllPetsInfo(), 30);
        return redisUtil.get("allPetsInfo");
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

    @Override
    public void createAf(AdoptionForm adoptionForm) {
        adoptionForm.setAf_create_time(TimeUtils.getNowTime());
        petsMapper.createAf(adoptionForm);
    }
}
