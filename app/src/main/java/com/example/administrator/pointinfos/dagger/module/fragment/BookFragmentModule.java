package com.example.administrator.pointinfos.dagger.module.fragment;

import com.example.administrator.pointinfos.presenter.fragment.BookFragmentPresenter;
import com.example.administrator.pointinfos.ui.fragment.BookFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/3/13.
 */
@Module
public class BookFragmentModule {
    BookFragment fragment;

    public BookFragmentModule(BookFragment fragment) {
        this.fragment = fragment;
    }
    @Provides
    BookFragmentPresenter bookFragmentPresenter(){
        return new BookFragmentPresenter(fragment);
    }
}
