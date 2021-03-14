package com.mapper;

import com.pojo.BaseMessages;
import com.pojo.Bases;
import com.pojo.BasesImages;
import com.pojo.vo.BaseIdVo;
import com.pojo.vo.BaseMessageIdVo;
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
    List<BasesImages> queryBasesImagesById(BaseIdVo baseIdVo);
    List<BaseMessages> queryBaseMessages(BaseIdVo baseIdVo);
    void changeBasesById(Bases po);
    void changeBasesMessagesById(BaseMessages po);
    void insertBasesMessage(BaseMessages po);
    void delBasesMessageByBmId(BaseMessageIdVo vo);
    void changeBasesImageByBiId(BasesImages po);
}
