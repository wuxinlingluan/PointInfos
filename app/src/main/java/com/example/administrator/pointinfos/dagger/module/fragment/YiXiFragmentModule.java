package com.example.administrator.pointinfos.dagger.module.fragment;

import com.example.administrator.pointinfos.presenter.fragment.XiFragmentPresenter;
import com.example.administrator.pointinfos.ui.fragment.XiFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/3/13.
 */
@Module
public class YiXiFragmentModule {
    XiFragment fragment;

    public YiXiFragmentModule(XiFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    XiFragmentPresenter xiFragmentPresenter(){
        return new XiFragmentPresenter(fragment);
    }
}
