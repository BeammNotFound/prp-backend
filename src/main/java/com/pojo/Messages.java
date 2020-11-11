package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("资讯实体类")
public class Messages {
    private int m_id;
    private String m_title;
    private String m_details;
    private String m_author;
    private String m_image;
    @JsonIgnore
    private Date m_createtime;
    @JsonIgnore
    private Date m_updatetime;
    @JsonIgnore
    private Integer m_pv;
}
