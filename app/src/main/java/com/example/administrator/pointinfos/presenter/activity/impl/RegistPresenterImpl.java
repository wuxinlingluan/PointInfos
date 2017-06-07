package com.example.administrator.pointinfos.presenter.activity.impl;

import com.example.administrator.pointinfos.model.User;
import com.example.administrator.pointinfos.presenter.activity.RegistPresenter;
import com.example.administrator.pointinfos.presenter.view.RegistView;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by ${sheldon} on 2017/5/1.
 */

public class RegistPresenterImpl implements RegistPresenter {
    private RegistView registView;

    public RegistPresenterImpl(RegistView registView) {
        this.registView = registView;
    }

    @Override
    public void regist(final String username, final String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(final User user, final BmobException e) {
                    if (e==null){
                        //注册成功
                        registView.onRegist(username,password,true,null);
                    }else {
                        //注册失败
                        registView.onRegist(username,password,false,e.getMessage());
                    }
            }
        });
    }
}
