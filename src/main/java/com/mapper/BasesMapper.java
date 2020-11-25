package com.mapper;

import com.pojo.Bases;
import com.pojo.vo.DelBasesVo;
import com.pojo.vo.QueryBasesVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BasesMapper {
    List<Bases> queryBases();
    List<Bases> fuzzyQueryBases(QueryBasesVo bases);
    void delBases(DelBasesVo basesVo);
    Bases queryBasesById(Integer b_id);
}
