package com.androidjp.lib_four_components.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * 生命周期Log Activity
 *
 * Created by androidjp on 16-7-1.
 */
public abstract class LogActivity extends Activity{

    ///控制是否输出Log
    private static final boolean IS_LOG = true;

    /**
     *
     * @return TAG
     */
    abstract String getTag();

    //-------------------------------------------------------
    //正常生命周期方法
    //-------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onLog("onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        onLog("onStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        onLog("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        onLog("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        onLog("onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        onLog("onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onLog("onRestart()");
    }

    //-------------------------------------------------------
    //点击事件方法
    //-------------------------------------------------------


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onLog("onBackPressed()");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                onLog("click to back");
                break;
            case KeyEvent.KEYCODE_HOME:
                onLog("click to home");
                break;
            default:
                onLog("nothing");
                break;
        }

        return super.onKeyDown(keyCode, event);
    }


    //-------------------------------------------------------
    //Activity间跳转方法
    //-------------------------------------------------------
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onLog("onActivityResult()");
    }

    //-------------------------------------------------------
    //特殊生命周期方法
    //-------------------------------------------------------


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        onLog("onNewIntent()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        onLog("onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onLog("onRestoreInstanceState()");
    }




    //-------------------------------------------
    //-------------------------------------------
    public  void onLog(String logMsg){
        if (IS_LOG){
            Toast.makeText(this, getTag()+": "+logMsg, Toast.LENGTH_SHORT).show();
            Log.i(getTag(),logMsg);
        }
    }
}
