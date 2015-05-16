package com.yjrg.app.enumerate;

/**
 * Created by valuesFeng on 2014/6/20.
 */
public enum HttpUrl {
    LOGIN("/user/login");                  //用户登录

    private String url;
    private HttpUrl(String url) {
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}
