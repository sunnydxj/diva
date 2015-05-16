package com.yjrg.app.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by gavin on 14-6-8.
 */
public class DeviceUtil {

    /**
     * 获取设备序列号
     * @param context
     * @return
     */
    public static String getDeviceSerialNumber(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return  telephonyManager.getSimSerialNumber();
    }

    /**
     * 获取本机MIEI号码（仅手机存在）
     * @param context
     * @return
     */
    public static String getMIEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    /**
     * 获取本机电话号码
     * @param context
     * @return
     */
    public static String getPhoneNumber(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return  telephonyManager.getLine1Number();
    }
}
