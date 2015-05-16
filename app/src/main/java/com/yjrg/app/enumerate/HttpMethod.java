package com.yjrg.app.enumerate;

/**
 * Created by valuesFeng on 2014/6/20.
 */
public enum HttpMethod {
    GET("GET"),POST("POST"),PUT("PUT");
    private String method;
    private HttpMethod(String method) {
        this.method = method;
    }

    public String getMethod(){
        return method;
    }
}
