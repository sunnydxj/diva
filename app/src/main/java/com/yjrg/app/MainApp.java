package com.yjrg.app;

import android.app.Application;


public class MainApp extends Application {

    private static MainApp sInstance;
    private static int serverPort;
    private static String serverHost;

    public static int getServerPort() { return serverPort;}

    public static void setServerPort(int serverPort) { MainApp.serverPort = serverPort;}

    public static String getServerHost() { return serverHost;}

    public static void setServerHost(String serverHost) { MainApp.serverHost = serverHost; }

    public static MainApp getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

}
