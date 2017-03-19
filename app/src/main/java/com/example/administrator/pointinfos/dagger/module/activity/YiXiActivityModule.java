package com.example.administrator.pointinfos.dagger.module.activity;

import com.example.administrator.pointinfos.presenter.activity.YiXiDetailActivityPresenter;
import com.example.administrator.pointinfos.ui.activity.YiXiDetailActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${sheldon} on 2017/3/19.
 */
@Module
public class YiXiActivityModule {
    YiXiDetailActivity activity;

    public YiXiActivityModule(YiXiDetailActivity activity) {
        this.activity = activity;
    }
    @Provides
    YiXiDetailActivityPresenter yiXiDetailActivityPresenter(){
        return new YiXiDetailActivityPresenter(activity);
    }
}
