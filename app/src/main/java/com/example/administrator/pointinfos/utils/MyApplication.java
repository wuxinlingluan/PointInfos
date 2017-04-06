package com.example.administrator.pointinfos.utils;

import android.app.Application;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.controller.EaseUI;

/**
 * Created by ${sheldon} on 2017/4/6.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EaseUI.getInstance().init(this,null);//初始化
        EMClient.getInstance().setDebugMode(true);
    }
}
