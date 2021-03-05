package com.minee.java_sample.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.minee.java_sample.R;

public class DetailActivity extends BaseActivity {

    private static final String QUERY_NAME = "name";
    private static final String EXTRA_NAME = "EXTRA_NAME";

    private String name;

    public DetailActivity() {
        super(R.layout.activity_detail);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail);

        TextView tv_value = findViewById(R.id.tv_value);
        tv_value.setText(name);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(EXTRA_NAME, name);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void setSavedInstanceState(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getBundle(savedInstanceState);

        if (bundle == null) {
            finish();
        }

        String name = bundle.getString(EXTRA_NAME);
        if (name != null) {
            this.name = name;
        } else {
            finish();
        }
    }


    public static void startActivity(Context context, String name) {
        context.startActivity(getIntent(context, name));
    }

    private static Intent getIntent(Context context, String name) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        return intent;
    }

    public static Intent getIntent(Context context, Uri deepLink) {
        String name = deepLink.getQueryParameter(QUERY_NAME);
        if (name == null) {
            name = "";
        }
        return getIntent(context, name);
    }
}