package com.yjrg.app.util;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Gavin.Liu.
 */
public class LogUtil {

    private static String TAG = "cn.chogic.ts.app";
    private static final String ROOT = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ts/log/";
    private static String FILE_NAME = "ts.log";
    private static String logFile = ROOT + FILE_NAME;

    private static boolean write2Sdcard = true;

    public static void setWrite2Sdcard(boolean write2Sdcard) {
        LogUtil.write2Sdcard = write2Sdcard;
    }

    public static void v(String message) {
        String content = createMessage(message);
        Log.v(TAG, content);
    }

    public static void v(Throwable e) {
        Log.v(TAG, createMessage(e.getMessage()), e);
    }

    public static void d(String message) {
        String content = createMessage(message);
        Log.d(TAG, content);
    }

    public static void d(Throwable e) {
        Log.d(TAG, createMessage(e.getMessage()), e);
    }

    public static void i(String message) {
        String content = createMessage(message);
        Log.i(TAG, content);
        writeLog(content);
    }

    public static void i(Throwable e) {
        Log.i(TAG, createMessage(e.getMessage()), e);
        writeLog(createException(e));
    }

    public static void w(String message) {
        String content = createMessage(message);
        Log.w(TAG, content);
        writeLog(content);
    }

    public static void w(Throwable e) {
        Log.w(TAG, createMessage(e.getMessage()), e);
        writeLog(createException(e));
    }

    public static void e(String message) {
        String content = createMessage(message);
        Log.e(TAG, content);
        writeLog(content);
    }

    public static void e(Throwable e) {
        Log.e(TAG, createMessage(e.getMessage()), e);
        writeLog(createException(e));
    }

    public static void wtf(String msg) {
        String content = createMessage(msg);
        Log.wtf(TAG, content);
        writeLog(content);
    }

    private static String getPrefix() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();

        if (sts == null) {
            return null;
        }

        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }

            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }

            if (st.getClassName().equals(LogUtil.class.getName())) {
                continue;
            }

            return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId()
                    + "): " + st.getFileName() + ": " + st.getMethodName() + ": " + st.getLineNumber() + "]";
        }

        return null;
    }

    private static String createMessage(String msg) {
        String suffix = getPrefix();
        return (suffix == null ? msg : (suffix + " - " + msg));
    }

    private static String createException(Throwable e) {
        StringBuilder sb = new StringBuilder();
        String name = getPrefix();
        StackTraceElement[] sts = e.getStackTrace();

        if (name != null) {
            sb.append(name).append(" - ").append(e).append("\r\n");
        } else {
            sb.append(e).append("\r\n");
        }

        if (sts != null && sts.length > 0) {
            for (StackTraceElement st : sts) {
                if (st != null) {
                    sb.append("[ ").append(st.getFileName()).append(": ").append(st.getLineNumber()).append(" ]\r\n");
                }
            }
        }

        return sb.toString();
    }

    public static void resetLogFile() {
        if (!isMounted()) return;
        File file = new File(logFile);
        file.delete();

        try {
            File dir = new File(ROOT);
            dir.mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
        }

    }

    private static boolean isMounted() {
        String sdStatus = Environment.getExternalStorageState();
        return sdStatus.equals(Environment.MEDIA_MOUNTED);
    }

    private static void writeLog(String content) {

        if (!write2Sdcard) {
            return;
        }

        if (!isMounted()) return;

        try {
            File file = new File(logFile);

            if (!file.exists()) {
                File dir = new File(ROOT);
                dir.mkdirs();
                file.createNewFile();
            }

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            FileWriter write = new FileWriter(file, true);
            write.write(format.format(new Date()) + "   " +
                    content + "\n");
            write.flush();
            write.close();
        } catch (IOException e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
        }

    }
}
