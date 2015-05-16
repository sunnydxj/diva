package com.yjrg.app.net.http.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by valuesFeng on 14-6-8.
 */
public class DataResponse<T> {

    private int mCode;

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
}
