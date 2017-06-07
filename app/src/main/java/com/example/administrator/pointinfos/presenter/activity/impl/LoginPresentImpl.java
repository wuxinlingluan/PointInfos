package com.example.administrator.pointinfos.presenter.activity.impl;

import com.example.administrator.pointinfos.model.User;
import com.example.administrator.pointinfos.presenter.activity.LoginPresenter;
import com.example.administrator.pointinfos.presenter.view.LoginView;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

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
        User user = new User();   //实例化用户对象
        user.setUsername(username);
        user.setPassword(pwd);
        user.login(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
              if (e==null){
                  loginView.onLogin(username,pwd,true,null);
              } else {
                  loginView.onLogin(username,pwd,false,e.toString());
              }
            }
        });
    }
}
