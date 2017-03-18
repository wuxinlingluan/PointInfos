package com.example.administrator.pointinfos.dagger.componet.fragment;

import com.example.administrator.pointinfos.dagger.module.fragment.YiXiFragmentModule;
import com.example.administrator.pointinfos.ui.fragment.XiFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/3/13.
 */
@Component(modules = YiXiFragmentModule.class)
public interface YiXiFragmentComponet {
        void in(XiFragment xiFragment);
}
