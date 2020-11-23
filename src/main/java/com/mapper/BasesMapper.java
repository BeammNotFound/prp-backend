package com.mapper;


import com.pojo.Bases;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BasesMapper {
    Bases queryBases();
}
