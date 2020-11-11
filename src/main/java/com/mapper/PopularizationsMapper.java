package com.mapper;

import com.pojo.Popularizations;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PopularizationsMapper {
    Popularizations queryPopularizationsList();
    void createPopularization(Popularizations popularizations);
}
