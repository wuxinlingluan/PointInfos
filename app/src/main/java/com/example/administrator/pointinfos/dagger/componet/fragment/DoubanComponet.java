package com.example.administrator.pointinfos.dagger.componet.fragment;

import com.example.administrator.pointinfos.dagger.module.fragment.DoubanFragmentModule;
import com.example.administrator.pointinfos.ui.fragment.DoubanFragment;

import dagger.Component;

/**
 * Created by ${sheldon} on 2017/6/7.
 */
@Component(modules = DoubanFragmentModule.class)
public interface DoubanComponet {
    void in(DoubanFragment doubanFragment);
}
