package com.service.impl;

import com.common.utils.RedisUtil;
import com.mapper.BasesMapper;
import com.pojo.BaseMessages;
import com.pojo.Bases;
import com.pojo.BasesImages;
import com.pojo.vo.BaseIdVo;
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
    public void delBases(BaseIdVo baseIdVo) {
        if (redisUtil.hasKey("allBases"))
            redisUtil.del("allBases");
        basesMapper.delBases(baseIdVo);
    }

    @Override
    public Bases queryBasesById(Integer base_id) {
        return basesMapper.queryBasesById(base_id);
    }

    @Override
    public List<BasesImages> queryBasesImagesById(BaseIdVo baseIdVo) {
        return basesMapper.queryBasesImagesById(baseIdVo);
    }

    @Override
    public List<BaseMessages> queryBaseMessages(BaseIdVo baseIdVo) {
        return basesMapper.queryBaseMessages(baseIdVo);
    }

    @Override
    public void changeBasesById(Bases po) {
        basesMapper.changeBasesById(po);
    }
}
