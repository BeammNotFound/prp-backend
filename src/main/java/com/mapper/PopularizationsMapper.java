package com.mapper;

import com.pojo.Messages;
import com.pojo.Popularizations;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PopularizationsMapper {
    List<Popularizations> queryPopularizationsList();
    void createPopularization(Popularizations popularizations);
}
