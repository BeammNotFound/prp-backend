package com.mapper;

import com.pojo.vo.QueryVolunteerByIdVo;
import com.pojo.Volunteer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Mapper
@Repository

public interface VolunteerMapper {
    void userApplication(Volunteer applicationVo);
    QueryVolunteerByIdVo queryVolunteerById(Integer user_id);

    Volunteer queryVolunteerByBaseId(Integer base_id);
}
