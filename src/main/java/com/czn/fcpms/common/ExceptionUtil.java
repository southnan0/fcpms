package com.czn.fcpms.common;

import com.czn.fcpms.enums.ResultEnum;

public class ExceptionUtil extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ExceptionUtil(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
