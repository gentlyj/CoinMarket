package com.ifading.coinmarket;

import android.app.Application;

import timber.log.Timber;

/**
 * Created  on 20180319//.
 *
 * @author by yangjingsheng
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
