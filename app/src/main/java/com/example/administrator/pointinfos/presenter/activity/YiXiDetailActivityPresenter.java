package com.example.administrator.pointinfos.presenter.activity;

import com.example.administrator.pointinfos.model.net.bean.YiXiDetailBean;
import com.example.administrator.pointinfos.presenter.base.BasePresenter;
import com.example.administrator.pointinfos.ui.activity.YiXiDetailActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ${sheldon} on 2017/3/19.
 *
 */

public class YiXiDetailActivityPresenter extends BasePresenter {
    private YiXiDetailActivity yiXiDetailActivity;

    public YiXiDetailActivityPresenter(YiXiDetailActivity yiXiDetailActivity) {
        this.yiXiDetailActivity = yiXiDetailActivity;
    }
    //获取演讲详情页数据
    public void getYiXiDetail(String id){
        responseInfoAPI.getyixidetail(id).enqueue(new Callback<YiXiDetailBean>() {
            @Override
            public void onResponse(Call<YiXiDetailBean> call, Response<YiXiDetailBean> response) {
                if (response!=null&&response.isSuccessful()){
                    yiXiDetailActivity.success(response.body().getData());
                }

            }

            @Override
            public void onFailure(Call<YiXiDetailBean> call, Throwable t) {

            }
        });
    }
}
