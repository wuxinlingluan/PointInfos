package com.example.administrator.pointinfos.utils;

import android.content.Context;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by ${sheldon} on 2017/6/7.
 */

public class CommonUtils {
    /**
     * 清空用户的登录信息
     */
    public static void cleanUserLoginInfo() {
        Context context = UIUtils.getContext();
        SharedPreferencesUtils.putBoolean(context,
                Constant.AL_LOGIN, false);
        SharedPreferencesUtils.putString(context,Constant.SP_KEY_USERNAME,"");
        SharedPreferencesUtils.putString(context,Constant.SP_KEY_PWD,"");
        // 调用此 API 来设置标签。
        Set<String> tagSet = new LinkedHashSet<String>();
        tagSet.add("0" + "");
    }
}
