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
    private int id;
    private String title;
    private String details;
    private String author;
    private String image;
    @JsonIgnore
    private Date create_time;
    @JsonIgnore
    private Date update_time;
}
