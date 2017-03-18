package com.example.administrator.pointinfos.presenter.fragment;

import com.example.administrator.pointinfos.model.net.bean.YiXiBean;
import com.example.administrator.pointinfos.presenter.base.BasePresenter;
import com.example.administrator.pointinfos.ui.fragment.XiFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/12.
 */

public class XiFragmentPresenter extends BasePresenter {
   private XiFragment fragment;
    public XiFragmentPresenter(XiFragment fragment) {
        this.fragment = fragment;
    }

    //获取新闻数据
    public  void getDate(){
        Call<YiXiBean> yiXiBeanCall = responseInfoAPI.getyixiInfo();
        yiXiBeanCall.enqueue(new Callback<YiXiBean>() {
            @Override
            public void onResponse(Call<YiXiBean> call, Response<YiXiBean> response) {
                //获取数据
                if (response!=null&&response.isSuccessful()){
                    fragment.success(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<YiXiBean> call, Throwable t) {
                //失败
            }
        });
    }



}
