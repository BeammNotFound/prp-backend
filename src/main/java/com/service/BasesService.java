package com.service;

import com.pojo.Bases;
import com.pojo.vo.QueryBasesVo;

import java.util.List;

public interface BasesService {
    List<Bases> queryBases();

    List<Bases> fuzzyQueryBases(QueryBasesVo bases);

}
