package com.example.greendaotest;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/9/23.
 */

public class App extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
