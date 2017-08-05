package com.essejose.a13mobincrivelfirebase;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by logonrm on 05/08/2017.
 */

public class MinhaAplicacao extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

    }
}
