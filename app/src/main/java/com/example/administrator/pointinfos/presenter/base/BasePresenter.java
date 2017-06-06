package com.example.administrator.pointinfos.presenter.base;

import com.example.administrator.pointinfos.presenter.api.ResponseInfoAPI;
import com.example.administrator.pointinfos.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/12.
 * 业务层基类抽取
 */

public class BasePresenter {


    protected static ResponseInfoAPI responseInfoAPI;

    public BasePresenter() {
        if (responseInfoAPI==null) {
          Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASEURL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
            responseInfoAPI = retrofit.create(ResponseInfoAPI.class);
        }
    }
}
