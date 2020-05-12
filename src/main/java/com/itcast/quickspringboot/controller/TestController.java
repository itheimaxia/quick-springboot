package com.itcast.quickspringboot.controller;

import com.itcast.quickspringboot.bean.Result;
import com.itcast.quickspringboot.bo.PageBO;
import com.itcast.quickspringboot.bo.UserBO;
import com.itcast.quickspringboot.constant.StatusCode;
import com.itcast.quickspringboot.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestController {

    private Logger log = LoggerFactory.getLogger(TestController.class);

    private void throwTest() throws UserException {
        throw new UserException("测试用户错误");
    }


    @RequestMapping("test1")
    public Result test1() throws UserException {
        throwTest();
        return new Result(true, StatusCode.OK, "成功");
    }

    @RequestMapping("test2")
    public Result test2() {
        int i = 1/0;
        return new Result(true, StatusCode.OK, "成功");
    }

    @RequestMapping(value = "validator", method = RequestMethod.POST)
    public Result test3(@Valid @RequestBody PageBO param) {
        return null;
    }

    @RequestMapping(value = "getUser", method = RequestMethod.POST)
    public Result getUser(@Valid @RequestBody UserBO param) {

        return null;
    }

    @RequestMapping(value = "log")
    public Result test3() {
        log.info("log info");
        log.error("log error");
        return null;
    }
}
