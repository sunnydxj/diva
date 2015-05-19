package com.yjrg.app.manager;

import android.content.Context;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.UrlConnectionClient;

/**
 * Created by gavin on 14-6-7.
 */
public class RestClient {

    static String HTTP = "http://121.41.114.128:8080/";
    static String DOMAIN = "shop/";
    static String BASE_URL = HTTP + DOMAIN;

    public static RestAdapter getAdapter(Context context) {
        return new RestAdapter.Builder().setEndpoint(BASE_URL)
                .setClient(new UrlConnectionClient())
                .setConverter(new JsonConvert())
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
