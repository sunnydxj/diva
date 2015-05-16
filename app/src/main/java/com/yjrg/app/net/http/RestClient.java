package com.yjrg.app.net.http;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;

/**
 * Created by gavin on 14-6-7.
 */
public class RestClient {

    static String HTTP = "http://";
    static String DOMAIN = "";
    static String BASE_URL = HTTP + DOMAIN;

    public static RestAdapter getAdapter() {
        return new RestAdapter.Builder().setEndpoint(BASE_URL)
                .setClient(new OkClient())
                .setConverter(new JsonConvert())
//                .setLog(new RestAdapter.Log() {
//                    @Override
//                    public void log(String message) {
//                        LogUtil.i(message);
//                    }
//                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setErrorHandler(new CloudErrorHandler())
                .build();
    }

    private static class CloudErrorHandler implements ErrorHandler {

        @Override
        public Throwable handleError(RetrofitError cause) {
            return cause;
        }

    }
}
