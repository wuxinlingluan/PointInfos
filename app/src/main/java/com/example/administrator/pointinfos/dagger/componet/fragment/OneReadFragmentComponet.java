package com.example.administrator.pointinfos.dagger.componet.fragment;

import com.example.administrator.pointinfos.dagger.module.fragment.OneReadFragmentModule;
import com.example.administrator.pointinfos.ui.fragment.OneReadFragment;

import dagger.Component;

/**
 * Created by ${sheldon} on 2017/4/4.
 */
@Component(modules = OneReadFragmentModule.class)
public interface OneReadFragmentComponet {
    void in(OneReadFragment fragment);
}
