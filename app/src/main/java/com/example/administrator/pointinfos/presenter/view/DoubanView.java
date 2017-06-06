package com.example.administrator.pointinfos.presenter.view;

import com.example.administrator.pointinfos.model.net.bean.DoubanBean;

import java.util.List;

/**
 * Created by ${sheldon} on 2017/6/6.
 */

public interface DoubanView {
    void showData(List<DoubanBean> bean);
    void showProgressBar();
    void hideProgressBar();
    void showeFailure();
}
