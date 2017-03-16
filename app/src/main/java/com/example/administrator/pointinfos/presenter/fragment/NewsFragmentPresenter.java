package com.example.administrator.pointinfos.presenter.fragment;

import com.example.administrator.pointinfos.model.net.bean.NewsBean;
import com.example.administrator.pointinfos.presenter.BasePresenter;
import com.example.administrator.pointinfos.ui.fragment.NewsFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/12.
 */

public class NewsFragmentPresenter extends BasePresenter {
    private NewsFragment fragment;

    public NewsFragmentPresenter(NewsFragment fragment) {
        this.fragment = fragment;
    }

    //获取新闻数据
    public  void getDate(){
        Call<NewsBean> getnewsinfo = responseInfoAPI.getnewsinfo("1b4862c0040bf72d8079a70d7a3386ba");
        getnewsinfo.enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                //成功
                if (response!=null&&response.isSuccessful()){
                    fragment.success(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {

            }
        });
    }



}