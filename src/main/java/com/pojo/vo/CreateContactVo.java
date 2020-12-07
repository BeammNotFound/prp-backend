package com.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Data
public class CreateContactVo {
    @NotNull(message = "用户名id不能为空")
    private Integer user_id;
    @NotBlank(message = "留言内容不能为空")
    private String c_words;
    @JsonIgnore
    private Date c_createtime;
}
