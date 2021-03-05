package com.minee.java_sample.deeplink;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @LayoutRes
    private int layoutResId;

    public BaseActivity() {
        super();
    }

    public BaseActivity(int layoutResId) {
        super();
        this.layoutResId = layoutResId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResId);

    }

    @Nullable
    protected Bundle getBundle(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            return getIntent().getExtras();
        } else {
            return null;
        }
    }

    protected void setSavedInstanceState(@Nullable Bundle savedInstanceState) {}
}