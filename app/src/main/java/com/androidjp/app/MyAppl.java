package com.androidjp.app;

import android.app.Application;
import android.content.Context;

import com.androidjp.lib_common_util.system.KeyBoardUtil;

/**
 * Created by androidjp on 16-7-21.
 */
public class MyAppl extends Application {

//    private static MyAppl sInstance;
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();


    }

    public static Context getContext(){
        return appContext;
    }

}
