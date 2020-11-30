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
@ApiModel("背景图片实体类")
public class Background {
    private Integer i_id;
    private String i_name;
    private String i_src;

    @JsonIgnore
    private Date i_createtime;
}
