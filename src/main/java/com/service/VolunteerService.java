package com.service;

import com.pojo.ApplicationVolunteer;
import com.pojo.VolunteerFrom;
import com.pojo.VolunteerInfo;
import com.pojo.vo.QueryVolunteerByIdVo;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
public interface VolunteerService {

    Integer userApplication(ApplicationVolunteer vo);

    QueryVolunteerByIdVo queryAppVolunteerById(Integer user_id);

    VolunteerInfo queryVolunteerInfoByBaseId(Integer base_id);

    void createVF(VolunteerFrom volunteerFrom);

    Object queryAllVolunteer();
}
