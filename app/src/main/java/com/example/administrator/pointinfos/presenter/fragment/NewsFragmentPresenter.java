package com.example.administrator.pointinfos.presenter.fragment;

import com.blankj.utilcode.util.ToastUtils;
import com.example.administrator.pointinfos.model.net.bean.NewsBean;
import com.example.administrator.pointinfos.presenter.base.BasePresenter;
import com.example.administrator.pointinfos.ui.fragment.NewsFragment;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/3/12.
 */

public class NewsFragmentPresenter extends BasePresenter {
    private NewsFragment fragment;
    public NewsFragmentPresenter(NewsFragment fragment) {
        this.fragment = fragment;
    }

    //获取新闻数据
    public void getDate(){
      responseInfoAPI.getnewsinfo("1b4862c0040bf72d8079a70d7a3386ba").
              subscribeOn(Schedulers.io()).
              observeOn(AndroidSchedulers.mainThread()).
              subscribe(new MySubscriber());
    }
    class MySubscriber extends Subscriber<NewsBean> {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            ToastUtils.showShort("加载失败");
        }

        @Override
        public void onNext(NewsBean newsBean) {
            fragment.success(newsBean.getResult());
        }
    }

}
