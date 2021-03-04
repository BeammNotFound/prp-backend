package com.mapper;


import com.pojo.AdoptionForm;
import com.pojo.AdoptionPats;
import com.pojo.PetsInfo;
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

    List<AdoptionPats> queryAdoptionForm();


}
