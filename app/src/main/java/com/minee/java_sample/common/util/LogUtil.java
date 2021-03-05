package com.minee.java_sample.common.util;

import android.util.Log;

import com.minee.java_sample.BuildConfig;

import java.lang.reflect.Method;

public class LogUtil {
    private static final String TAG = "minee";

    private static final int ASSERT = 1;
    private static final int ERROR = 2;
    private static final int WARN = 3;
    private static final int INFO = 4;
    private static final int DEBUG = 5;
    private static final int VERBOSE = 6;

    public static final void e(String message) {
        e(TAG, message);
    }

    public static final void e(String tag, String message) {
        printLog(tag, message, ERROR);
    }

    public static final void w(String message) {
        w(TAG, message);
    }

    public static final void w(String tag, String message) {
        printLog(tag, message, WARN);
    }

    public static final void i(String message) {
        i(TAG, message);
    }

    public static final void i(String tag, String message) {
        printLog(tag, message, INFO);
    }

    public static final void d(String message) {
        d(TAG, message);
    }

    public static final void d(String tag, String message) {
        printLog(tag, message, DEBUG);
    }

    public static final void v(String message) {
        v(TAG, message);
    }

    public static final void v(String tag, String message) {
        printLog(tag, message, VERBOSE);
    }

    private static void printLog(String tag, String message, int level) {
        if ("debug".equalsIgnoreCase(BuildConfig.BUILD_TYPE) || getLogLevel() >= level) {
            String logMessage = buildLogMsg(message);
            switch (level) {
                case ASSERT:
                    break;
                case ERROR:
                    Log.e(tag, logMessage);
                    break;
                case WARN:
                    Log.w(tag, logMessage);
                    break;
                case INFO:
                    Log.i(tag, logMessage);
                    break;
                case DEBUG:
                    Log.d(tag, logMessage);
                    break;
                case VERBOSE:
                    Log.v(tag, logMessage);
                    break;
            }
        }
    }

    private static String buildLogMsg(String message) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(ste.getFileName().replace(".java", ""));
        sb.append("::");
        sb.append(ste.getMethodName());
        sb.append("] ");
        sb.append(message);

        return sb.toString();
    }

    private static int getLogLevel() {
        try {
            Class clazz = Class.forName("android.os.SystemProperties");
            Method method = clazz.getMethod("getInt", String.class, int.class);
            return (Integer) method.invoke(clazz, "persist.sys.minee.debug", 0);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
