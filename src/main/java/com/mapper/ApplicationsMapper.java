package com.mapper;

import com.pojo.vo.QueryUserApplication;
import com.pojo.vo.UserApplicationVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Mapper
@Repository

public interface ApplicationsMapper {
    void userApplication(UserApplicationVo applicationVo);
    QueryUserApplication queryUserApplication(Integer user_id);
}
