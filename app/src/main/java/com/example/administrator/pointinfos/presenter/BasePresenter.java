package com.example.administrator.pointinfos.presenter;

import com.example.administrator.pointinfos.utils.Constant;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/12.
 * 业务层基类抽取
 */

public class BasePresenter {


    public BasePresenter() {
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(Constant.BASEURL);
        builder.addConverterFactory(GsonConverterFactory.create());//Gson解析
        Retrofit retrofit=builder.build();
        api=retrofit.create(ResponseInfoAPI.class);
    }
}
