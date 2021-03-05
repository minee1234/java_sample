package com.minee.java_sample.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import com.minee.java_sample.MainActivity;
import com.minee.java_sample.common.util.LogUtil;

public class SchemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_scheme);

        handleDeepLink();
    }

    private void handleDeepLink() {
        Uri deepLinkUri = getIntent().getData();
        LogUtil.d("deepLinkUri: " + deepLinkUri);

        Intent deepLinkIntent = DeepLinkInfo.getMainIntent(this);
        if (deepLinkUri != null) {
            deepLinkIntent = DeepLinkInfo.invoke(deepLinkUri).getIntent(this, deepLinkUri);
        }

        if (isTaskRoot()) {
            TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
            if (needAddMainForParent(deepLinkIntent)) {
                taskStackBuilder.addNextIntentWithParentStack(DeepLinkInfo.getMainIntent(this));
            }
            taskStackBuilder.addNextIntent(deepLinkIntent);
            taskStackBuilder.startActivities();
        } else {
            startActivity(deepLinkIntent);
        }

        finish();
    }

    private Boolean needAddMainForParent(Intent intent) {
        try {
            return !MainActivity.class.getName().equals(intent.getComponent().getClassName());
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}