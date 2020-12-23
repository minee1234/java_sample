package com.minee.java_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.minee.java_sample.common.widget.CustomToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_custom_toast:
                CustomToast.makeText(this, "Custom Toast", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
