package com.service;

import com.pojo.PetsInfo;

import java.util.List;

public interface PetsService {
    List<PetsInfo> queryPetsInfoByBaseId(Integer base_id);
}
