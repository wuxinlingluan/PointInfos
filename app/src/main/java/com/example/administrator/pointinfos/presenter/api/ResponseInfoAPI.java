package com.example.administrator.pointinfos.presenter.api;

import com.example.administrator.pointinfos.model.net.bean.EverydayReadBean;
import com.example.administrator.pointinfos.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/3/12.
 */

public interface ResponseInfoAPI {
    @GET(Constant.BASEURL)
    Call<EverydayReadBean> getbookinfo();
}
