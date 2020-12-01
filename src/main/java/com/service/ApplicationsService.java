package com.service;

import com.pojo.vo.QueryUserApplication;
import com.pojo.vo.UserApplicationVo;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
public interface ApplicationsService {

    Boolean userApplication(UserApplicationVo applicationVo);

    QueryUserApplication queryUserApplication(Integer user_id);
}
