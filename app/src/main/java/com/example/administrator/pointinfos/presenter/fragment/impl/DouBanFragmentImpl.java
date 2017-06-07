package com.example.administrator.pointinfos.presenter.fragment.impl;

import android.util.Log;

import com.example.administrator.pointinfos.model.net.bean.DoubanBean;
import com.example.administrator.pointinfos.presenter.base.BasePresenter;
import com.example.administrator.pointinfos.presenter.fragment.DouBanFragmentPresenter;
import com.example.administrator.pointinfos.presenter.view.DoubanView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ${sheldon} on 2017/6/6.
 */

public class DouBanFragmentImpl extends BasePresenter implements DouBanFragmentPresenter {
    private DoubanView mDoubanView;
    private List<DoubanBean> list=new ArrayList<>();
    public DouBanFragmentImpl(DoubanView mDoubanView) {
        this.mDoubanView = mDoubanView;
    }

    @Override
    public void getData() {
        mDoubanView.showProgressBar();
        Date mDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(mDate);
        Log.i("111111111111",dateNowStr);
        responseInfoAPI.getdoubaninfo(dateNowStr).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new MySubscriber());;
    }

    @Override
    public void getMoreData() {

    }
    class MySubscriber extends Subscriber<DoubanBean> {
        @Override
        public void onCompleted() {
            mDoubanView.hideProgressBar();
            mDoubanView.showData(list);
        }
        @Override
        public void onError(Throwable e) {
            mDoubanView.hideProgressBar();
            mDoubanView.showeFailure();
        }
        @Override
        public void onNext(DoubanBean doubanBean) {
            mDoubanView.hideProgressBar();
            list.add(doubanBean);
        }
    }

}
