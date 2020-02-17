package com.example.intsigdemo.Application;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static MyApplication getInstance(){
        return mApplication;
    }
}
