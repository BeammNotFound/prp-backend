package com.service;

import com.pojo.Volunteer;
import com.pojo.VolunteerFrom;
import com.pojo.vo.QueryVolunteerByIdVo;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
public interface VolunteerService {

    Integer userApplication(Volunteer applicationVo);

    QueryVolunteerByIdVo queryVolunteerById(Integer user_id);

    Volunteer queryVolunteerByBaseId(Integer base_id);

    void createVF(VolunteerFrom volunteerFrom);


}
