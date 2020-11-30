package com.service.impl;

import com.common.utils.RedisUtil;
import com.mapper.BasesMapper;
import com.pojo.Bases;
import com.pojo.BasesImages;
import com.pojo.AdoptionPets;
import com.pojo.vo.DelBasesVo;
import com.pojo.vo.QueryBasesVo;
import com.service.BasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasesServiceImpl implements BasesService {

    @Autowired
    private BasesMapper basesMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Object queryBases() {
        if (redisUtil.hasKey("allBases"))
            return redisUtil.get("allBases");
        else
            redisUtil.set("allBases", basesMapper.queryBases(),30);
            return redisUtil.get("allBases");
    }

    @Override
    public List<Bases> fuzzyQueryBases(QueryBasesVo bases) {
        return basesMapper.fuzzyQueryBases(bases);
    }

    @Override
    public void delBases(DelBasesVo basesVo) {
        if (redisUtil.hasKey("allBases"))
            redisUtil.del("allBases");
        basesMapper.delBases(basesVo);
    }

    @Override
    public Bases queryBasesById(Integer b_id) {
        return basesMapper.queryBasesById(b_id);
    }

    @Override
    public List<AdoptionPets> queryAPList(Integer ap_base) {
        return basesMapper.queryAPList(ap_base);
    }

    @Override
    public List<BasesImages> queryBasesImagesById(Integer bi_base) {
        return basesMapper.queryBasesImagesById(bi_base);
    }
}
