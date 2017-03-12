package com.example.administrator.pointinfos.presenter.fragment;

import com.example.administrator.pointinfos.model.net.bean.EverydayReadBean;
import com.example.administrator.pointinfos.presenter.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/12.
 */

public class BookFragmentPresenter extends BasePresenter {
    //获取数据
    public  void getDate(){
        Call<EverydayReadBean> getbookinfo = responseInfoAPI.getbookinfo();
        getbookinfo.enqueue(new Callback<EverydayReadBean>() {
            @Override
            public void onResponse(Call<EverydayReadBean> call, Response<EverydayReadBean> response) {
                //正确返回
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<EverydayReadBean> call, Throwable t) {

            }
        });
    }
}
