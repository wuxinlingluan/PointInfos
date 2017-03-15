package com.example.administrator.pointinfos.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.ui.base.BaseFragment;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

//新闻界面
public class NewsFragment extends BaseFragment {
    @InjectView(R.id.progressbar)
    ProgressBar progressbar;
    @InjectView(R.id.rcl)
    RecyclerView rcl;
    @InjectView(R.id.tkr)
    TwinklingRefreshLayout tkr;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_news;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        return rootView;
    }
    //获取数据
    @Override
    public void onResume() {
        super.onResume();
    }
}
