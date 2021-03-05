package com.minee.java_sample;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class BaseApplication extends Application implements Thread.UncaughtExceptionHandler {

    private Thread.UncaughtExceptionHandler systemUncaughtExceptionHandler;
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        try {
            //systemUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            //Thread.setDefaultUncaughtExceptionHandler(this::uncaughtException);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        final boolean background = getMainLooper().getThread() != t;

        FirebaseCrashlytics.getInstance().recordException(e);
        if (background) {
            final Handler handler = new Handler(getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    systemUncaughtExceptionHandler.uncaughtException(t, e);
                }
            });
        } else {
            systemUncaughtExceptionHandler.uncaughtException(t, e);
        }

    }

    public static BaseApplication getInstance() {
        return instance;
    }

}
