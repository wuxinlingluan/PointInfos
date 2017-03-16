package com.example.administrator.pointinfos.dagger.module.fragment;

import com.example.administrator.pointinfos.presenter.fragment.WechartFragmentPresenter;
import com.example.administrator.pointinfos.ui.fragment.WechartFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${sheldon} on 2017/3/16.
 */
@Module
public class WechartFragmentModule {
    WechartFragment wechartFragment;

    public WechartFragmentModule(WechartFragment wechartFragment) {
        this.wechartFragment = wechartFragment;
    }

    @Provides
    WechartFragmentPresenter wechartFragmentPresenter(){
        return new WechartFragmentPresenter(wechartFragment);
    }
}
