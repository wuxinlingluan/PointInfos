package com.example.administrator.pointinfos.dagger.module.fragment;

import com.example.administrator.pointinfos.presenter.fragment.NewsFragmentPresenter;
import com.example.administrator.pointinfos.ui.fragment.NewsFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${sheldon} on 2017/3/16.
 */
@Module
public class NewsFragmentModule {
    NewsFragment newsFragment;

    public NewsFragmentModule(NewsFragment newsFragment) {
        this.newsFragment = newsFragment;
    }
    @Provides
    NewsFragmentPresenter newsFragmentPresenter(){
        return new NewsFragmentPresenter(newsFragment);
    }
}
