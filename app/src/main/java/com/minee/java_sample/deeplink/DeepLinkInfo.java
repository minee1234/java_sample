package com.minee.java_sample.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.StringRes;

import com.minee.java_sample.BaseApplication;
import com.minee.java_sample.MainActivity;
import com.minee.java_sample.R;
import com.minee.java_sample.common.util.LogUtil;

public enum DeepLinkInfo {

    MAIN(R.string.scheme_host_main) {
        @Override
        Intent getIntent(Context context, Uri deepLinkUri) {
            return getMainIntent(context);
        }
    },

    DETAIL(R.string.scheme_host_detail) {
        @Override
        Intent getIntent(Context context, Uri deepLinkUri) {
            return DetailActivity.getIntent(context, deepLinkUri);
        }
    },

    COUNTRY(R.string.scheme_host_country) {
        @Override
        Intent getIntent(Context context, Uri deepLinkUri) {
            return CountryActivity.getIntent(context, deepLinkUri);
        }
    };


    @StringRes
    private int hostStringResId;

    abstract Intent getIntent(Context context, Uri deepLinkUri);

    DeepLinkInfo(int hostStringResId) {
        this.hostStringResId = hostStringResId;
    }

    private String getHost() {
        return BaseApplication.getInstance().getString(hostStringResId);
    }

    public static Intent getMainIntent(Context context) {
        return MainActivity.getIntent(context);
    }

    public static DeepLinkInfo invoke(Uri uri) {
        for (DeepLinkInfo deepLinkInfo : DeepLinkInfo.values()) {
            if (deepLinkInfo.getHost().equals(uri.getHost())) {
                return deepLinkInfo;
            }
        }
        LogUtil.e("Not registered deep link host");
        return MAIN;
    }

}
