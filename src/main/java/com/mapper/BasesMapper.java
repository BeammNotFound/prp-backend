package com.mapper;

import com.pojo.Bases;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BasesMapper {
    List<Bases> queryBases();
}
