package com.example.administrator.pointinfos.presenter.activity.impl;

import com.example.administrator.pointinfos.presenter.activity.LoginPresenter;
import com.example.administrator.pointinfos.presenter.view.LoginView;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

/**
 * Created by ${sheldon} on 2017/5/1.
 */

public class LoginPresentImpl implements LoginPresenter {
    private LoginView loginView;

    public LoginPresentImpl(LoginView loginView) {
        this.loginView = loginView;
    }


    @Override
    public void login(final String username, final String pwd) {
        EMClient.getInstance().login(username, pwd, new EMCallBack() {
            @Override
            public void onSuccess() {
                loginView.onLogin(username,pwd,true,null);
            }

            @Override
            public void onError(int i, String s) {
                loginView.onLogin(username,pwd,false,s.toString());
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }
}
