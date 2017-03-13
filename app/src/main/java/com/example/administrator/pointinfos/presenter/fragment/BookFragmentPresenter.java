package com.example.administrator.pointinfos.presenter.fragment;

import com.example.administrator.pointinfos.model.net.bean.EverydayReadBean;
import com.example.administrator.pointinfos.presenter.BasePresenter;
import com.example.administrator.pointinfos.ui.fragment.BookFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/3/12.
 */

public class BookFragmentPresenter extends BasePresenter {
    private BookFragment fragment;

    public BookFragmentPresenter(BookFragment fragment) {
        this.fragment = fragment;
    }

    //获取数据
    public  void getDate(){
        Call<EverydayReadBean> getbookinfo = responseInfoAPI.getbookinfo("1");
        getbookinfo.enqueue(new Callback<EverydayReadBean>() {
            @Override
            public void onResponse(Call<EverydayReadBean> call, Response<EverydayReadBean> response) {
                //正确返回
              if (response!=null&&response.isSuccessful()){
                        fragment.success(response.body());
                   } else {
                  //服务器返回有误
                   }
            }

            @Override
            public void onFailure(Call<EverydayReadBean> call, Throwable t) {

            }
        });
    }



}
