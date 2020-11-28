package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Background {
    private Integer i_id;
    private String i_name;
    private String i_src;

    @JsonIgnore
    private Date i_createtime;
}
