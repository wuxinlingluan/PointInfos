package com.example.administrator.pointinfos.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by ${sheldon} on 2017/6/7.
 */

public class UIUtils {
    /**
     * 上下文
     *
     * @return
     */
    public static Context getContext() {
        return MyApplication.getContext();
    }

    public static Resources getResources() {
        return getContext().getResources();
    }

    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    public static String getString(int id, Object... formatArgs) {
        return getResources().getString(id, formatArgs);
    }

    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    public static String getPackageName() {
        return getContext().getPackageName();
    }

    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }


    public static Handler getMainHandler() {
        return MyApplication.getMainHandler();
    }

    public static long getMainThreadId() {
        return MyApplication.getMainThreadId();
    }



    /**
     * 让task在主线程中执行
     */
    public static void post(Runnable task) {
        int myTid = android.os.Process.myTid();

        if (myTid == getMainThreadId()) {
            // 在主线程中执行的
            task.run();
        } else {
            // 在子线程中执行的
            getMainHandler().post(task);
        }
    }

    /**
     * dip 转 px
     *
     * @param dip
     * @return
     */
    public static int dip2px(int dip) {
        // 公式： dp = px / (dpi / 160) px = dp * (dpi / 160)
        // dp = px / denisity
        // px = dp * denisity;
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float density = metrics.density;
        return (int) (dip * density + 0.5f);
    }

    /**
     * px转dip
     *
     * @param px
     * @return
     */
    public static int px2dip(int px) {
        // dp = px / denisity
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float density = metrics.density;
        return (int) (px / density + 0.5f);
    }

    /**
     *
     * @param
     * @param dp
     * @return
     */
    public static int dpToPx(Resources res, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                res.getDisplayMetrics());
    }

    /**
     * dp转px
     *
     * @param
     * @param dp
     * @return
     */
    public static int dpToPx(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    /**
     * 获取屏幕宽度
     *
     * @param activity
     * @return
     */
    public static int getWidthPixels(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param activity
     * @return
     */
    public static int getHeightPixels(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    /**
     * 执行延时任务
     *
     */
    public static void postDelayed(Runnable task, int delayed) {
        getMainHandler().postDelayed(task, delayed);
    }

    /**
     * 移除任务
     *
     * @param task
     */
    public static void removeCallbacks(Runnable task) {
        getMainHandler().removeCallbacks(task);
    }

    /**
     * 解决用代码直接设置选择器无效的方案
     *
     * @param view
     * @param res
     */
    public static void setTextColorSelector(TextView view, int res) {
        // 通过资源id获取xml解析器
        XmlResourceParser xrp = getResources().getXml(res);
        try {
            // 创建颜色选择状态集合
            ColorStateList csl = ColorStateList.createFromXml(getResources(),
                    xrp);
            // 设置颜色
            view.setTextColor(csl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

