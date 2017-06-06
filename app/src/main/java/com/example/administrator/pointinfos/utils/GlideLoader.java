package com.example.administrator.pointinfos.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by ${sheldon} on 2017/6/6.
 */

public class GlideLoader {
    public static void loadLocal(Activity activity, String url, ImageView iv) {    //不缓存，全部从网络加载
        Glide.with(activity).load(url).into(iv);
    }
    public static void load(Activity activity, String url, ImageView iv) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
        if (!activity.isDestroyed()) {
            Glide.with(activity).load(url).centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(iv);
        }
    }
    public static void loadNoCacheAll(Context context, String url, ImageView iv) {    //不设置默认
        Glide.with(context).load( url).crossFade().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(iv);
    }
    public static void loadCircle(Context context, String url, int erroImg, int emptyImg, ImageView iv) { //加载圆形
        Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new GlideCircleTransform(context)).into(iv);
    }

    public static void loadRound(Context context, String url, int erroImg, int emptyImg, ImageView iv, int dp) { //加载圆角
        Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new GlideRoundTransform(context, dp)).into(iv);
    }
}
