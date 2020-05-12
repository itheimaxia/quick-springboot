package com.itcast.quickspringboot.bo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class UserBO {

    //Blank = null || ""
    @NotBlank(message = "不能为空")
    //@Pattern(regexp="^[0-9]{1,2}$",message="年龄是整数")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}