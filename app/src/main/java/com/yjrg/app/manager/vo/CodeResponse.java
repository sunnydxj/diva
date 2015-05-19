package com.yjrg.app.manager.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by valuesFeng on 2014/6/3.
 */
public class CodeResponse {

    @JSONField(name = "code")
    private int code;
    @JSONField(name = "msg")
    private String msg;

    @JSONField(name = "code")
    public int getCode() {
        return code;
    }

    @JSONField(name = "code")
    public void setCode(int code) {
        this.code = code;
    }

    @JSONField(name = "msg")
    public String getMsg() {
        return msg;
    }

    @JSONField(name = "msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
