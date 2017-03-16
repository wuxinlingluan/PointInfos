package com.example.administrator.pointinfos.dagger.componet.fragment;

import com.example.administrator.pointinfos.dagger.module.fragment.NewsFragmentModule;
import com.example.administrator.pointinfos.ui.fragment.NewsFragment;

import dagger.Component;

/**
 * Created by ${sheldon} on 2017/3/16.
 */
@Component(modules = NewsFragmentModule.class)
public interface NewsFragmentComponet {
    void in(NewsFragment newsFragment);
}
