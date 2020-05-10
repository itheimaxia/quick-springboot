package com.itcast.quickspringboot.config;

import com.itcast.quickspringboot.bean.Result;
import com.itcast.quickspringboot.constant.StatusCode;
import com.itcast.quickspringboot.controller.TestController;
import com.itcast.quickspringboot.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {

    private Logger log = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler(value = UserException.class)
    @ResponseBody
    public Result userError(UserException e) {
        log.error("用户异常",e);
        return new Result(false, StatusCode.USERERROR, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result binding(MethodArgumentNotValidException ex) {
        StringBuilder sb = new StringBuilder();
        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            if(error instanceof FieldError){
                FieldError e = (FieldError) error;
                sb.append(e.getField() + e.getDefaultMessage() + " ");
            }
        }
        return new Result(false, StatusCode.PARAMETER_ERROR, sb.toString());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}