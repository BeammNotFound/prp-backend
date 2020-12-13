package com.service;

import com.pojo.ApplicationVolunteer;
import com.pojo.VolunteerForm;
import com.pojo.VolunteerInfo;
import com.pojo.vo.QueryVolunteerByIdVo;
import com.pojo.vo.UserIdVo;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
public interface VolunteerService {

    Integer userApplication(ApplicationVolunteer vo);

    QueryVolunteerByIdVo queryAppVolunteerById(Integer user_id);

    VolunteerInfo queryVolunteerInfoByBaseId(Integer base_id);

    void createVolunteerForm(VolunteerForm volunteerForm);

    Object queryAllVolunteer();

    void cancelApplicationVolunteer(UserIdVo vo);
}
