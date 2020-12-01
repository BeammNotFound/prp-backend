package com.mapper;


import com.pojo.vo.CreateContactVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ContactMapper {
    void createContact(CreateContactVo contactVo);
}
