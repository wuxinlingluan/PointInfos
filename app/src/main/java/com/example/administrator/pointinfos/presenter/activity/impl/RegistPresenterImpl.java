package com.example.administrator.pointinfos.presenter.activity.impl;

import com.example.administrator.pointinfos.model.User;
import com.example.administrator.pointinfos.presenter.activity.RegistPresenter;
import com.example.administrator.pointinfos.presenter.view.RegistView;
import com.example.administrator.pointinfos.utils.ThreadUtils;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

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
                        ThreadUtils.runOnBackgroundThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    EMClient.getInstance().createAccount(username,password);//环信注册成功
                                    ThreadUtils.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            registView.onRegist(username,password,true,null);
                                        }
                                    });
                                } catch (final HyphenateException el) {
                                    el.printStackTrace();//环信注册失败
                                    ThreadUtils.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            user.delete();
                                            registView.onRegist(username,password,false,el.toString());
                                        }
                                    });
                                }
                            }
                        });
                    }else {
                        //注册失败
                        registView.onRegist(username,password,false,e.getMessage());
                    }
            }
        });
    }
}
