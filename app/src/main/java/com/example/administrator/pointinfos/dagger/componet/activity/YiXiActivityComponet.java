package com.example.administrator.pointinfos.dagger.componet.activity;

import com.example.administrator.pointinfos.dagger.module.activity.YiXiActivityModule;
import com.example.administrator.pointinfos.ui.activity.YiXiDetailActivity;

import dagger.Component;

/**
 * Created by ${sheldon} on 2017/3/19.
 */
@Component(modules = YiXiActivityModule.class)
public interface YiXiActivityComponet {
    void in (YiXiDetailActivity activity);
}
