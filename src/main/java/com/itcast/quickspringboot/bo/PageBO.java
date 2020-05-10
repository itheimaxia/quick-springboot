package com.itcast.quickspringboot.bo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PageBO {
    @NotNull
    @Range(min = 1,max = 100,message = "一次性获取最大列表数不能超过100")
    private Integer pageSize;

    @NotNull
    @Min(value = 1,message = "必须大于0")
    private Integer pageNum;

    @NotNull
    private String queryString;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}