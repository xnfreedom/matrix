package com.tencent.matrix.trace.core;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tencent.matrix.Matrix;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.DynamicConfigImplDemo;

public class TraceInstaller extends ContentProvider {
    public static String TAG = "Matrix.TraceInstaller";
    @Override
    public boolean onCreate() {

        DynamicConfigImplDemo dynamicConfig = new DynamicConfigImplDemo();
        Context context = getContext();
        Application application = null;
        if (context != null){
            application = (Application)context.getApplicationContext();
        }
        Matrix.Builder builder = new Matrix.Builder(application);
        boolean fpsEnable = dynamicConfig.isFPSEnable();
        boolean traceEnable = dynamicConfig.isTraceEnable();
        TraceConfig traceConfig = new TraceConfig.Builder()
                .dynamicConfig(dynamicConfig)
                .enableFPS(fpsEnable)
                .enableEvilMethodTrace(traceEnable)
                .enableAnrTrace(traceEnable)
                .enableStartup(traceEnable)
                //.splashActivities("com.example.gctest.MainActivity")
                .isDebug(true)
                .isDevEnv(false)
                .build();

        TracePlugin tracePlugin = (new TracePlugin(traceConfig));
        builder.plugin(tracePlugin);
        Matrix.init(builder.build());
        //start only startup tracer, close other tracer.
        tracePlugin.start();
        Log.d(TAG, "tracePlugin started!");
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] strings, String s, String[] strings1,
                        String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
