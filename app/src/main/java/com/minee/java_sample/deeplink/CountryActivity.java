package com.minee.java_sample.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.minee.java_sample.R;

public class CountryActivity extends BaseActivity {
    private static final String QUERY_COUNTRY = "id";
    private static final String EXTRA_ID = "EXTRA_ID";

    private String id;

    public CountryActivity() {
        super(R.layout.activity_country);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_country);

        TextView tv_value = findViewById(R.id.tv_value);
        tv_value.setText(id);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(EXTRA_ID, id);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void setSavedInstanceState(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getBundle(savedInstanceState);

        if (bundle == null) {
            finish();
        }

        String id = bundle.getString(EXTRA_ID);
        if (id != null) {
            this.id = id;
        } else {
            finish();
        }
    }

    public static void startActivity(Context context, String id) {
        context.startActivity(getIntent(context, id));
    }

    private static Intent getIntent(Context context, String id) {
        Intent intent = new Intent(context, CountryActivity.class);
        intent.putExtra(EXTRA_ID, id);
        return intent;
    }

    public static Intent getIntent(Context context, Uri deepLink) {
        String id = deepLink.getQueryParameter(QUERY_COUNTRY);
        if (id == null) {
            id = "";
        }
        return getIntent(context, id);
    }
}