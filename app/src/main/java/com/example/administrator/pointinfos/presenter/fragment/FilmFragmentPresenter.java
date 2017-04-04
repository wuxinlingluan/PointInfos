package com.example.administrator.pointinfos.presenter.fragment;

import com.example.administrator.pointinfos.model.net.bean.FilmBean;
import com.example.administrator.pointinfos.presenter.base.BasePresenter;
import com.example.administrator.pointinfos.ui.fragment.FilmFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ${sheldon} on 2017/4/4.
 */

public class FilmFragmentPresenter extends BasePresenter {
    private FilmFragment filmFragment;

    public FilmFragmentPresenter(FilmFragment filmFragment) {
        this.filmFragment = filmFragment;
    }
    //获取电影数据
    public void getData() {
        responseInfoAPI.getfilminfo().enqueue(new Callback<FilmBean>() {
            @Override
            public void onResponse(Call<FilmBean> call, Response<FilmBean> response) {
                    if (response!=null&&response.isSuccessful()){
                        //获取数据成功
                        filmFragment.success((List<FilmBean.DataBean.MoviesBean>) response.body().getData().getMovies());
                    }
            }

            @Override
            public void onFailure(Call<FilmBean> call, Throwable t) {
                    filmFragment.fail();
            }
        });
    }


}
