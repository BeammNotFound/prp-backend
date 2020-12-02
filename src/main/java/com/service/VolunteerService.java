package com.service;

import com.pojo.vo.QueryVolunteerByIdVo;
import com.pojo.Volunteer;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
public interface VolunteerService {

    Integer userApplication(Volunteer applicationVo);

    QueryVolunteerByIdVo queryVolunteerById(Integer user_id);

    Volunteer queryVolunteerByBaseId(Integer base_id);

}
