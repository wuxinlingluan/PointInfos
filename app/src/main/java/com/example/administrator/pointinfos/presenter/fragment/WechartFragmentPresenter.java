package com.example.administrator.pointinfos.presenter.fragment;

import com.example.administrator.pointinfos.model.net.bean.WeChartBean;
import com.example.administrator.pointinfos.presenter.BasePresenter;
import com.example.administrator.pointinfos.ui.fragment.WechartFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/12.
 */

public class WechartFragmentPresenter extends BasePresenter {
    private String key="d57cf2241b7ee0a9a6bbaa8b16cd3fa2";
    private WechartFragment fragment;

    public WechartFragmentPresenter(WechartFragment fragment) {
        this.fragment = fragment;
    }

    //获取微信数据
    public  void getDate(int pageNum){
     responseInfoAPI.getwechartinfo(key, pageNum + "").enqueue(new Callback<WeChartBean>() {
         @Override
         public void onResponse(Call<WeChartBean> call, Response<WeChartBean> response) {
             if (response!=null&&response.isSuccessful()){
                 fragment.success(response.body().getResult());
             }
         }

         @Override
         public void onFailure(Call<WeChartBean> call, Throwable t) {

         }
     });
    }
}
