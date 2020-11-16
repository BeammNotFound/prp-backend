package com.mapper;

import com.pojo.User;
import com.pojo.vo.LoginVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {
    User login(LoginVo user);
}
