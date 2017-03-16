package com.example.administrator.pointinfos.dagger.componet.fragment;

import com.example.administrator.pointinfos.dagger.module.fragment.WechartFragmentModule;
import com.example.administrator.pointinfos.ui.fragment.WechartFragment;

import dagger.Component;

/**
 * Created by ${sheldon} on 2017/3/16.
 */
@Component(modules = WechartFragmentModule.class)
public interface WechartFragmentComponet {
    void in(WechartFragment wechartFragment);
}
