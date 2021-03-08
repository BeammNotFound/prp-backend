package com.service.impl;

import com.common.utils.RedisUtil;
import com.common.utils.TimeUtils;
import com.mapper.PetsMapper;
import com.mapper.UserMapper;
import com.pojo.AdoptionPats;
import com.pojo.AdoptionForm;
import com.pojo.PetsInfo;
import com.pojo.vo.*;
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
    public List<PetsInfo> queryPetByName(String pi_name) {
        return petsMapper.queryPetByName(pi_name);
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
    public Integer adoptPet(AdoptionPats adoptionPats) {
        //判断是否有这个用户
        if (userMapper.queryUserById(adoptionPats.getUser_id()) == null) {
            return 3;
        }
        //判断是否已经领养
        List<AdoptionPats> ls = petsMapper.queryAdoptPetByUserId(adoptionPats.getUser_id());
        if (ls != null) {
            for (AdoptionPats l : ls) {
                if (l.getPet_id().equals(adoptionPats.getPet_id())) {
                    return 2;
                }
            }
        }
        adoptionPats.setAp_application_time(TimeUtils.getNowTime());
        adoptionPats.setAp_status("待审批");
        petsMapper.adoptPet(adoptionPats);
        return 1;
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

    @Override
    public List<AdoptionPats> queryAdoptionFormByUserId(UserIdVo vo) {
        return petsMapper.queryAdoptionFormByUserId(vo);
    }

    @Override
    public void updateApStatusByid(ApStatusVo apStatusVo) {
        petsMapper.updateApStatusByid(apStatusVo);
    }

    @Override
    public void updateApPassTimeByid(ApStatusVo apStatusVo) {
        petsMapper.updateApPassTimeByid(apStatusVo);
    }

    @Override
    public List<ApFormVo> queryApFormByStatus(ApStatusVo vo) {
        return petsMapper.queryApFormByStatus(vo);
    }

    @Override
    public List<PetsInfoVo> queryAdoptedPetsInfo() {
        return petsMapper.queryAdoptedPetsInfo();
    }

    @Override
    public List<PetsInfoVo> queryUnAdoptedPetsInfo() {
        return petsMapper.queryUnAdoptedPetsInfo();
    }

    @Override
    public void insertPetInfo(PetsInfo po) {
        po.setPi_createtime(TimeUtils.getNowTime());
        petsMapper.insertPetInfo(po);
        redisUtil.del("AllpetsInfo");
        po.setAp_status("待领养");
        List<PetsInfo> petsInfos = petsMapper.queryPetByName(po.getPi_name());
        if (petsInfos != null) {
            for (PetsInfo p : petsInfos) {
                if (p.getPi_name().equals(po.getPi_name())){
                    po.setPet_id(p.getPi_id());
                }
            }
        }
        petsMapper.insertAdoptionPet(po);
    }

    @Override
    public void delPetByid(PetIdVo vo) {
        petsMapper.delPetInfoByid(vo);
        vo.setPet_id(vo.getPi_id());
        petsMapper.delAdopitonPetByid(vo);
        redisUtil.del("allPetsInfo");
    }

    @Override
    public void changePetInfo(PetInfoVo vo) {
        petsMapper.changePetInfo(vo);
        redisUtil.del("allPetsInfo");
    }
}
