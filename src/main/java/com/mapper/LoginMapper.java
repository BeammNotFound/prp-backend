package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Mapper
@Repository
public interface LoginMapper {
    User login(String userName);
}
