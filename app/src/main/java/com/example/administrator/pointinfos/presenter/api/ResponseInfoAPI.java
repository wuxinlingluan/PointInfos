package com.example.administrator.pointinfos.presenter.api;

import com.example.administrator.pointinfos.model.net.bean.EverydayReadBean;
import com.example.administrator.pointinfos.model.net.bean.FilmBean;
import com.example.administrator.pointinfos.model.net.bean.NewsBean;
import com.example.administrator.pointinfos.model.net.bean.OneReadBean;
import com.example.administrator.pointinfos.model.net.bean.WeChartBean;
import com.example.administrator.pointinfos.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/3/12.
 */

public interface ResponseInfoAPI {
    @GET(Constant.EVERYDAYAPI)
    Call<EverydayReadBean> getbookinfo(@Query("dev") String dev);
    @GET(Constant.NEWSAPI)
    Call<NewsBean> getnewsinfo(@Query("key") String key);
    @GET(Constant.WECHARTAPI)
    Call<WeChartBean> getwechartinfo(@Query("key") String key,@Query("pno") String pageNum);
    @GET(Constant.ONEREAD)
    Call<OneReadBean> getoneinfo();
    @GET(Constant.FILM)
    Call<FilmBean> getfilminfo();

}
