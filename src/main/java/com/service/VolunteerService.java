package com.service;

import com.pojo.ApplicationVolunteer;
import com.pojo.VolunteerForm;
import com.pojo.VolunteerInfo;
import com.pojo.vo.*;

import java.util.List;

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
    List<VolunteerForm> queryVolunteerFrom();
    void updateAVStatusByid(ApplicationVo applicationVo);
    void updateAVPassTimeByid(ApplicationVo applicationVo);
    List<AvFormVo> queryAvFormByStatus(AvStatusVo vo);
    void changeVolunteerInfo(VolunteerInfoVo vo);
    void createVolunteerInfo(VolunteerInfo po);
    void delVolunteerInfoByid(VolunteerInfoIdVo vo);

}
