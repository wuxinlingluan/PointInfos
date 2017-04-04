package com.example.administrator.pointinfos.presenter.fragment;

import com.example.administrator.pointinfos.model.net.bean.OneRReadBean;
import com.example.administrator.pointinfos.presenter.base.BasePresenter;
import com.example.administrator.pointinfos.ui.fragment.OneReadFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ${sheldon} on 2017/4/4.
 */

public class OneReadFragmentPresenter extends BasePresenter {
    private OneReadFragment oneReadFragment;

    public OneReadFragmentPresenter(OneReadFragment oneReadFragment) {
        this.oneReadFragment = oneReadFragment;
    }

    //获取一个阅读数据
    public void getData() {
        Call<OneRReadBean> getoneinfo = responseInfoAPI.getoneinfo();
        getoneinfo.enqueue(new Callback<OneRReadBean>() {
            @Override
            public void onResponse(Call<OneRReadBean> call, Response<OneRReadBean> response) {
                if (response!=null&&response.isSuccessful()){
                    oneReadFragment.success(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<OneRReadBean> call, Throwable t) {
                oneReadFragment.fail();
            }
        });
    }
}
