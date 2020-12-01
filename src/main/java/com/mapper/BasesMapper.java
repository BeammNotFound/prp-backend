package com.mapper;

import com.pojo.AdoptionPets;
import com.pojo.BaseMessages;
import com.pojo.Bases;
import com.pojo.BasesImages;
import com.pojo.vo.BaseIdVo;
import com.pojo.vo.QueryBasesVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BasesMapper {
    List<Bases> queryBases();
    List<Bases> fuzzyQueryBases(QueryBasesVo bases);
    void delBases(BaseIdVo baseIdVo);
    Bases queryBasesById(Integer base_id);
    List<AdoptionPets> queryAPList(BaseIdVo baseIdVo);
    List<BasesImages> queryBasesImagesById(BaseIdVo baseIdVo);
    List<BaseMessages> queryBaseMessages(BaseIdVo baseIdVo);
}
