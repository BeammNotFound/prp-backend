package com.service.impl;

import com.mapper.BasesMapper;
import com.pojo.Bases;
import com.pojo.vo.QueryBasesVo;
import com.service.BasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasesServiceImpl implements BasesService {

    @Autowired
    BasesMapper basesMapper;

    @Override
    public List<Bases> queryBases() {
        return basesMapper.queryBases();
    }

    @Override
    public List<Bases> fuzzyQueryBases(QueryBasesVo bases) {
        return basesMapper.fuzzyQueryBases(bases);
    }
}
