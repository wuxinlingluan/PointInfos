package com.example.administrator.pointinfos.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ${sheldon} on 2017/6/7.
 */

public class SharedPreferencesUtils  {

    /**
     * 存放字串符类型
     *
     * @param context
     * @param name
     * @param value
     */
    public static void putString(Context context, String name, String value) {
        SharedPreferences sp = context.getSharedPreferences(
                Common.APK_CONFIG, Context.MODE_PRIVATE);
        sp.edit().putString(name, value).commit();
    }
    /**
     * 获取字符串类型
     *
     * @param context
     * @param name
     * @return
     */
    public static String getString(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(
                Common.APK_CONFIG, Context.MODE_PRIVATE);
        return sp.getString(name, "");
    }
    /**
     * 存放布尔值类型
     *
     * @param context
     * @param name
     * @param value
     */
    public static void putBoolean(Context context, String name, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(
                Common.APK_CONFIG, Context.MODE_PRIVATE);
        sp.edit().putBoolean(name, value).commit();
    }

    /**
     * 获取布尔值
     *
     * @param context
     * @param name
     * @return
     */
    public static boolean getBoolean(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(
                Common.APK_CONFIG, Context.MODE_PRIVATE);
        return sp.getBoolean(name, false);
    }



}
