package com.yjrg.app.manager.login;

import com.yjrg.app.manager.vo.CodeResponse;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by ${valuesFeng} on ${2014.9.1}.
 */
public interface ILoginAPI {

    @FormUrlEncoded
    @POST("/{url}")
    public CodeResponse login(@Path(value = "url", encode = false) String url,
                                       @Field("version") String version,
                                       @Field("mobile") String mobile,
                                       @Field("passwd") String passwd,
                                       @Field("uuid") String uuid,
                                       @Field("platforminfo") String platforminfo,
                                       @Field("systeminfo") String systeminfo) throws Throwable;


}
