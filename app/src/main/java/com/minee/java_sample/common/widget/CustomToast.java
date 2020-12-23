package com.minee.java_sample.common.widget;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.minee.java_sample.R;

public class CustomToast extends Toast {
    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public CustomToast(Context context) {
        super(context);
    }

    public static Toast makeText(Context context, String message, int duration) {
        Toast toast = new Toast(context);

        View custonView = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);

        TextView textView = custonView.findViewById(R.id.message);
        textView.setText(message);

        toast.setView(custonView);
        toast.setDuration(duration);
        toast.setGravity(Gravity.CENTER, 0, toast.getYOffset() * -1);

        return toast;
    }
}
