package com.example.administrator.pointinfos.dagger.componet.fragment;

import com.example.administrator.pointinfos.dagger.module.fragment.BookFragmentModule;
import com.example.administrator.pointinfos.ui.fragment.BookFragment;

import dagger.Component;

/**
 * Created by Administrator on 2017/3/13.
 */
@Component(modules = BookFragmentModule.class)
public interface BookFragmentComponet {
        void in(BookFragment bookFragment);
}
