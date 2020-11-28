package com.mapper;

import com.pojo.Background;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BackgroundMapper {
    Background queryImageById(Integer i_id);
    List<Background> queryAllImages();
}
