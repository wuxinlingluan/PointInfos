package com.example.administrator.pointinfos.dagger.module.fragment;

import com.example.administrator.pointinfos.presenter.fragment.OneReadFragmentPresenter;
import com.example.administrator.pointinfos.ui.fragment.OneReadFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${sheldon} on 2017/4/4.
 */
@Module
public class OneReadFragmentModule {
    private OneReadFragment fragment;

    public OneReadFragmentModule(OneReadFragment fragment) {
        this.fragment = fragment;
    }
    @Provides
    OneReadFragmentPresenter oneReadFragmentPresenter(){
        return new OneReadFragmentPresenter(fragment);
    }
}
