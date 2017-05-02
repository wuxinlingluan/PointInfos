package com.example.administrator.pointinfos.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ${sheldon} on 2017/5/1.
 */

public class SPUtils {
    /**
     * 获取字符串类型
     *
     * @param context
     * @param name
     * @return
     */
    public static String getString(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(
                Constant.APK_CONFIG, Context.MODE_PRIVATE);
        return sp.getString(name, "");
    }

    /**
     * 存放字串符类型
     *
     * @param context
     * @param name
     * @param value
     */
    public static void putString(Context context, String name, String value) {
        SharedPreferences sp = context.getSharedPreferences(
                Constant.APK_CONFIG, Context.MODE_PRIVATE);
        sp.edit().putString(name, value).commit();
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
                Constant.APK_CONFIG, Context.MODE_PRIVATE);
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
                Constant.APK_CONFIG, Context.MODE_PRIVATE);
        return sp.getBoolean(name, false);
    }

    /**
     * 存放整数
     *
     * @param context
     * @param name
     * @param value
     */
    public static void putInt(Context context, String name, int value) {
        SharedPreferences sp = context.getSharedPreferences(
                Constant.APK_CONFIG, Context.MODE_PRIVATE);
        sp.edit().putInt(name, value).commit();
    }

    /**
     * 获取整形值
     *
     * @param context
     * @param name
     * @return
     */
    public static int getInt(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(
                Constant.APK_CONFIG, Context.MODE_PRIVATE);
        return sp.getInt(name, 0);
    }

    /**
     * 存放小数
     *
     * @param context
     * @param name
     * @param value
     */
    public static void putFloat(Context context, String name, float value) {
        SharedPreferences sp = context.getSharedPreferences(
                Constant.APK_CONFIG, Context.MODE_PRIVATE);
        sp.edit().putFloat(name, value).commit();
    }

    /**
     * 获取整形值
     *
     * @param context
     * @param name
     * @return
     */
    public static float getFloat(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(
                Constant.APK_CONFIG, Context.MODE_PRIVATE);
        return sp.getFloat(name, 0);
    }
}
