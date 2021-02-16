package com.minee.java_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.minee.java_sample.common.widget.CustomToast;
import com.minee.java_sample.ui.PokemonActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_custom_toast:
                //throw new RuntimeException("Test Crash");
                CustomToast.makeText(this, "Custom Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_reactive:
                Intent intent = new Intent(this, PokemonActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }
}
