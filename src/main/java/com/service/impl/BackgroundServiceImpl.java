package com.service.impl;

import com.common.utils.RedisUtil;
import com.mapper.BackgroundMapper;
import com.pojo.Background;
import com.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BackgroundServiceImpl implements BackgroundService {

    @Autowired
    private BackgroundMapper backgroundMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Background queryImageById() {
        int size;
        if (redisUtil.hasKey("allBackground")) {
            List allBackground = (List) redisUtil.get("allBackground");
            size = allBackground.size();
        }else {
            redisUtil.set("allBackground",backgroundMapper.queryAllImages(),30);
            List allBackground = (List) redisUtil.get("allBackground");
            size = allBackground.size();
        }
        int i_id = new Random().nextInt(size) + 1;
        return backgroundMapper.queryImageById(i_id);
    }

    @Override
    public List<Background> queryAllImages() {
        return (List<Background>) redisUtil.get("allBackground");
    }
}
