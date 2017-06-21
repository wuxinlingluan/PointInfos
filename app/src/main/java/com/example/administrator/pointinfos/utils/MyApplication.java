package com.example.administrator.pointinfos.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.mob.MobApplication;

import cn.bmob.v3.Bmob;

/**
 * Created by ${sheldon} on 2017/4/6.
 */

public class MyApplication extends MobApplication {
    private static Handler mMainHandler;
    private static long mMainThreadId;
    private static Context mContext;
    private static Thread mMainThread;
    private static Looper mMainLooper;
    @Override
    public void onCreate() {
        super.onCreate();
        initData();
        Bmob.initialize(this, "fbbf1c539efc20c3a428526d55a9adc1");
    }

    private void initData() {
        // 上下文
        mContext = getApplicationContext();
        // 主线程
        mMainThread = Thread.currentThread();
        // 主线程id
        mMainThreadId = android.os.Process.myTid();
        // 获取循环器
        mMainLooper = getMainLooper();
        // 创建主线程的handler
        mMainHandler = new Handler();
    }
    public static Thread getMainThread() {
        return mMainThread;
    }
    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }
    //    private List<Activity> activityList = new LinkedList<Activity>();
//    private static MyApplication instance;
//
//    private MyApplication() {
//    }
//
//    // 单例模式中获取唯一的MyApplication实例
//    public static MyApplication getInstance() {
//        if (null == instance) {
//            instance = new MyApplication();
//        }
//        return instance;
//    }
//
//    // 添加Activity到容器中
//    public void addActivity(Activity activity) {
//        activityList.add(activity);
//    }
//
//    // 遍历所有Activity并finish
//    public void exit() {
//        for (Activity activity : activityList) {
//            activity.finish();
//        }
//        System.exit(0);
//    }
public static Context getContext() {
    return mContext;
}
    public static Handler getMainHandler() {
        return mMainHandler;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }
}
