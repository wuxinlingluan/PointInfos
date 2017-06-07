package com.example.administrator.pointinfos.dagger.module.fragment;

import com.example.administrator.pointinfos.presenter.fragment.DouBanFragmentPresenter;
import com.example.administrator.pointinfos.presenter.fragment.impl.DouBanFragmentImpl;
import com.example.administrator.pointinfos.ui.fragment.DoubanFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${sheldon} on 2017/6/7.
 */
@Module
public class DoubanFragmentModule {
    DoubanFragment fragment;

    public DoubanFragmentModule(DoubanFragment fragment) {
        this.fragment = fragment;
    }
    @Provides
    DouBanFragmentPresenter douBanFragmentPresenter(){
        return new DouBanFragmentImpl(fragment);
    }
}
