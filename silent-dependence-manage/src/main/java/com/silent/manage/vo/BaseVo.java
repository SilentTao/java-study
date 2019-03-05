package com.silent.manage.vo;


import com.silent.manage.constants.Constant;
import com.silent.manage.pojo.BasePojo;

public class BaseVo extends BasePojo {

    private Integer code = Constant.RESPONSE_SUCCESS_CODE;//返回码
    private String msg = Constant.RESPONSE_SUCCESS_MSG;//返回描述
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
