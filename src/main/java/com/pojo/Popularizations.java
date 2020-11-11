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
@ApiModel("科普实体类")
public class Popularizations {
    private String p_title;
    private String p_details;
    private String p_author;
    @JsonIgnore
    private Integer p_pv;
    @JsonIgnore
    private Date p_createtime;
    @JsonIgnore
    private Date p_updatetime;
}
