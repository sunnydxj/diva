package com.yjrg.app.net.http.vo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by valuesFeng on 2014/6/3.
 */
public class CodeResponse {

    @JSONField(name = "code")
    private int mCode;

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }
}
