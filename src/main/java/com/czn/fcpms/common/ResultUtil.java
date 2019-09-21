package com.czn.fcpms.common;

import com.czn.fcpms.entity.Result;

public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);

        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer errCode, String errMsg){
        Result result = new Result();
        result.setCode(errCode);
        result.setMsg(errMsg);

        return result;
    }
}
