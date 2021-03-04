package com.service;

import com.pojo.AdoptionPats;
import com.pojo.AdoptionForm;
import com.pojo.PetsInfo;

import java.util.List;

public interface PetsService {
    List<PetsInfo> queryPetsInfoByBaseId(Integer base_id);
    List<PetsInfo> queryPetByName(String pi_name);
    Object queryAllPetsInfo();
    Integer adoptPet(AdoptionPats adoptionPats);
    List<PetsInfo> queryAdoptPet(Integer user_id);
    void createAf(AdoptionForm adoptionForm);

}
