package com.example.administrator.pointinfos.dagger.module.fragment;

import com.example.administrator.pointinfos.presenter.fragment.FilmFragmentPresenter;
import com.example.administrator.pointinfos.ui.fragment.FilmFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ${sheldon} on 2017/4/4.
 */
@Module
public class FilmFragmentModule {
    private FilmFragment fragment;

    public FilmFragmentModule(FilmFragment fragment) {
        this.fragment = fragment;
    }
    @Provides
    FilmFragmentPresenter filmFragmentPresenter(){
        return new FilmFragmentPresenter(fragment);
    }
}
