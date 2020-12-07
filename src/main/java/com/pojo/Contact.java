package com.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel("留言实体类")
public class Contact {
    private Integer t_id;
    @NotNull(message = "用户名不能为空")
    private Integer user_id;
    @NotNull(message = "留言内容不能为空")
    private String t_words;
    private Date t_createtime;
}
