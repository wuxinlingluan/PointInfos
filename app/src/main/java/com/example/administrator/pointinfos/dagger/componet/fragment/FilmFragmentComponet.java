package com.example.administrator.pointinfos.dagger.componet.fragment;

import com.example.administrator.pointinfos.dagger.module.fragment.FilmFragmentModule;
import com.example.administrator.pointinfos.ui.fragment.FilmFragment;

import dagger.Component;

/**
 * Created by ${sheldon} on 2017/4/4.
 */
@Component(modules = FilmFragmentModule.class)
public interface FilmFragmentComponet {
    void in(FilmFragment fragment);
}
