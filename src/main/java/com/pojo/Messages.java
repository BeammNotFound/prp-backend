package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@ApiModel("资讯实体类")
public class Messages {
    private int m_id;
    @NotBlank(message = "标题不能为空")
    private String m_title;
    @NotBlank(message = "内容不能为空")
    private String m_details;
    @NotBlank(message = "作者不能为空")
    private String m_author;
    private String m_image;
    @JsonIgnore
    private Date m_createtime;
    @JsonIgnore
    private Date m_updatetime;
    @JsonIgnore
    private Integer m_pv;
}
