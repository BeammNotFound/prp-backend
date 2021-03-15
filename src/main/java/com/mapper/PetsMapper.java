package com.mapper;


import com.pojo.AdoptionForm;
import com.pojo.AdoptionPats;
import com.pojo.PetsInfo;
import com.pojo.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PetsMapper {
    List<PetsInfo> queryPetsInfoByBaseId(Integer base_id);

    List<PetsInfo> queryAllPetsInfo();

    List<PetsInfo> queryPetByName(String pi_name);

    List<PetsInfo> queryAdoptPet(Integer base_id);

    List<AdoptionPats> queryAdoptPetByUserId(Integer user_id);

    void adoptPet(AdoptionPats adoptionPats);

    void createAf(AdoptionForm adoptionForm);

    List<AdoptionPats> queryAdoptionFormByUserId(UserIdVo vo);

    void updateApStatusByid(ApStatusVo apStatusVo);

    void updateApPassTimeByid(ApStatusVo apStatusVo);

    List<ApFormVo> queryApFormByStatus(ApStatusVo vo);

    List<PetsInfoVo> queryAdoptedPetsInfo();

    List<PetsInfoVo> queryUnAdoptedPetsInfo();

    void insertPetInfo(PetsInfo po);

    void insertAdoptionPet(PetsInfo po);

    void delPetInfoByid(PetIdVo vo);

    void delAdopitonPetByid(PetIdVo vo);

    void changePetInfo(PetInfoVo vo);

    List<PetsInfo> queryPetStarByUser_id(UserIdVo vo);

}
