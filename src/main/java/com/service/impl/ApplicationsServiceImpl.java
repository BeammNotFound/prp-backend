package com.service.impl;

import com.mapper.ApplicationsMapper;
import com.pojo.vo.QueryUserApplication;
import com.pojo.vo.UserApplicationVo;
import com.service.ApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Service
public class ApplicationsServiceImpl implements ApplicationsService {

    @Autowired
    private ApplicationsMapper mapper;

    @Override
    public Boolean userApplication(UserApplicationVo applicationVo) {
        if (applicationVo.getB_population() - applicationVo.getB_joinPopulation() <= 0 || applicationVo.getB_status() != 1) {
            return false;
        }
        mapper.userApplication(applicationVo);
        return true;
    }

    @Override
    public QueryUserApplication queryUserApplication(Integer user_id) {
        return mapper.queryUserApplication(user_id);
    }




}
