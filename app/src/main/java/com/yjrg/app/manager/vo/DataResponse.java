package com.yjrg.app.manager.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by valuesFeng on 14-6-8.
 */
public class DataResponse<T> {

    private int mCode;
    private String msg;
    private T mData;

    @JSONField(name = "code")
    public int getCode() {
        return mCode;
    }

    @JSONField(name = "code")
    public void setCode(int code) {
        mCode = code;
    }

    @JSONField(name = "data")
    public T getData() {
        return mData;
    }

    @JSONField(name = "data")
    public void setData(T data) {
        mData = data;
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
