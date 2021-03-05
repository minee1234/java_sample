package com.minee.java_sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.minee.java_sample.common.widget.CustomToast;
import com.minee.java_sample.arch.ui.PokemonActivity;
import com.minee.java_sample.deeplink.CountryActivity;
import com.minee.java_sample.deeplink.DetailActivity;

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

                String a = null;

                break;
            case R.id.btn_reactive:
                Intent intent = new Intent(this, PokemonActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_detail:
                DetailActivity.startActivity(this, "Main minee");
                break;

            case R.id.btn_country:
                CountryActivity.startActivity(this, "Main korea");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }
}
