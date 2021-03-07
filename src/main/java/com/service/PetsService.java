package com.service;

import com.pojo.AdoptionForm;
import com.pojo.AdoptionPats;
import com.pojo.PetsInfo;
import com.pojo.vo.*;

import java.util.List;

public interface PetsService {
    List<PetsInfo> queryPetsInfoByBaseId(Integer base_id);
    List<PetsInfo> queryPetByName(String pi_name);
    Object queryAllPetsInfo();
    Integer adoptPet(AdoptionPats adoptionPats);
    List<PetsInfo> queryAdoptPet(Integer user_id);
    void createAf(AdoptionForm adoptionForm);
    List<AdoptionPats> queryAdoptionForm();
    void updateApStatusByid(ApStatusVo apStatusVo);
    void updateApPassTimeByid(ApStatusVo apStatusVo);
    List<ApFormVo> queryApFormByStatus(ApStatusVo vo);
    List<PetsInfoVo> queryAdoptedPetsInfo();
    List<PetsInfoVo> queryUnAdoptedPetsInfo();
    void insertPetInfo(PetsInfo po);
    void delPetByid(PetIdVo vo);
    void changePetInfo(PetInfoVo vo);
}
