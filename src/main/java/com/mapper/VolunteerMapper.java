package com.mapper;

import com.pojo.ApplicationVolunteer;
import com.pojo.VolunteerFrom;
import com.pojo.VolunteerInfo;
import com.pojo.vo.QueryVolunteerByIdVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Mapper
@Repository

public interface VolunteerMapper {
    void userApplication(ApplicationVolunteer applicationVo);
    QueryVolunteerByIdVo queryAppVolunteerById(Integer user_id);

    VolunteerInfo queryVolunteerInfoByBaseId(Integer base_id);

    void updateJoinPopulationByBaseId(Integer base_id);

    void updateStatusByBaseId(ApplicationVolunteer vo);

    void createVF(VolunteerFrom volunteerFrom);
}
