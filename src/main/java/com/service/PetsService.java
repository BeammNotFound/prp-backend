package com.service;

import com.pojo.AdoptionPats;
import com.pojo.AdoptionForm;
import com.pojo.PetsInfo;

import java.util.List;

public interface PetsService {
    List<PetsInfo> queryPetsInfoByBaseId(Integer base_id);
    Object queryAllPetsInfo();
    Boolean adoptPet(AdoptionPats adoptionPats);
    List<PetsInfo> queryAdoptPet(Integer user_id);
    void createAf(AdoptionForm adoptionForm);

}
