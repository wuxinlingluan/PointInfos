package com.example.administrator.pointinfos.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.pointinfos.R;

import java.io.File;

/**
 * Created by ${sheldon} on 2017/3/16.
 */

public class IntentUtils {
    public static File cameraFile;


    /**
     * 切换界面并带有参数
     *
     * @param activity
     * @param cls
     * @param bundle
     */
    public static void changeActivity(Activity activity, Class<?> cls,
                                      Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_right_in,
                R.anim.activity_left_out);
    }

    /**
     * 从底部切换界面并带有参数
     *
     * @param activity
     * @param cls
     * @param bundle
     */
    public static void changeActivityFromBottom(Activity activity,
                                                Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_bottom_in,
                R.anim.activity_fade_out);
    }

    /**
     * 淡入切换界面并带有参数
     *
     * @param activity
     * @param cls
     * @param bundle
     */
    public static void changeActivityByFade(Activity activity, Class<?> cls,
                                            Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_fade_in,
                R.anim.activity_bottom_out);
    }


    /**
     * 切换界面
     *
     * @param activity
     * @param cls
     */
    public static void changeActivity(Activity activity, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_right_in,
                R.anim.activity_left_out);
    }

    /**
     * 淡入切换
     *
     * @param activity
     * @param cls
     */
    public static void changeActivityByFade(Activity activity, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_fade_in,
                R.anim.activity_bottom_out);
    }

    /**
     * 从底部切换界面
     *
     * @param activity
     * @param cls
     */
    public static void changeActivityFromBottom(Activity activity, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_bottom_in,
                R.anim.activity_fade_out);
    }


}
