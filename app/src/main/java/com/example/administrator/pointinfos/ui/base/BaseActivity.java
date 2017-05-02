package com.example.administrator.pointinfos.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.administrator.pointinfos.ui.activity.MainActivity;
import com.example.administrator.pointinfos.utils.Constant;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import butterknife.ButterKnife;

/**
 * Created by ${sheldon} on 2017/4/9.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected static List<Activity> mActivities = new LinkedList<Activity>();
    private Handler mHandler = new Handler();

    private ProgressDialog mProgressDialog;

    private InputMethodManager mInputMethodManager;

    private SharedPreferences mSharedPreferences;
    private long mPreTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        synchronized (mActivities) {
            mActivities.add(this);
        }
        ButterKnife.inject(this);
        mSharedPreferences = getSharedPreferences("config",MODE_PRIVATE);
        init();
    }

    protected void init() {}

    public abstract int getLayoutRes();

    protected void startActivity(Class activity) {
        startActivity(activity, true);
    }

    protected void startActivity(Class activity, boolean finish) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        if (finish) {
            finish();
        }
    }
    public void saveUser(String username,String pwd){
        mSharedPreferences.edit()
                .putString(Constant.SP_KEY_USERNAME,username)
                .putString(Constant.SP_KEY_PWD,pwd)
                .commit();
    }

    public String getUserName(){
        return mSharedPreferences.getString(Constant.SP_KEY_USERNAME,"");
    }
    public String getPwd(){
        return mSharedPreferences.getString(Constant.SP_KEY_PWD,"");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities) {
            mActivities.remove(this);
        }

    }

    /**
     * 退出应用
     */
    public static void exitApp() {
        // 遍历所有的activity，finish
        ListIterator<Activity> iterator = mActivities.listIterator();
        while (iterator.hasNext()) {
            Activity next = iterator.next();
            next.finish();
        }
    }
    protected void post(Runnable runnable) {
        postDelay(runnable, 0);
    }

    protected void postDelay(Runnable runnable, long millis) {
        mHandler.postDelayed(runnable, millis);
    }

    protected void showProgress(String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    protected void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected void hideKeyBoard() {
        if (mInputMethodManager == null) {
            mInputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        mInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    /**
     * 返回键的处理
     */
    @Override
    public void onBackPressed() {
        if (this instanceof MainActivity) {
            if (System.currentTimeMillis() - mPreTime > 2000) {
                Toast.makeText(this, "再按一次退出应用",
                        Toast.LENGTH_SHORT).show();
                mPreTime = System.currentTimeMillis();
                return;
            } else {
                exitApp();
                finish();
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }
}
