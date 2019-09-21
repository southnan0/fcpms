package com.czn.fcpms.common;

import com.czn.fcpms.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExeptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof  ExceptionUtil){
            ExceptionUtil exceptionUtil = (ExceptionUtil) e;
            return ResultUtil.error(exceptionUtil.getCode(),exceptionUtil.getMessage());
        }
        return ResultUtil.error(-1,e.getMessage());
    }
}
