package com.example.administrator.pointinfos.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.model.net.bean.OneRReadBean;
import com.example.administrator.pointinfos.presenter.fragment.OneReadFragmentPresenter;
import com.example.administrator.pointinfos.ui.base.BaseFragment;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

//一个阅读界面
public class OneReadFragment extends BaseFragment {
    @InjectView(R.id.rcl)
    RecyclerView rcl;
    @InjectView(R.id.tkr)
    TwinklingRefreshLayout tkr;
    @Inject
    OneReadFragmentPresenter oneReadFragmentPresenter;
    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_news;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        rcl.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcl.setHasFixedSize(true);
        return rootView;
    }
    //获取数据
    @Override
    public void onResume() {
        super.onResume();
        oneReadFragmentPresenter.getData();
    }
    //获取数据成功
    public void success(List<OneRReadBean.DataBean> data) {
            if (data!=null){

            }
    }
    //获取数据失败
    public void fail() {
        Toast.makeText(mActivity, "获取数据失败,请稍后再试", Toast.LENGTH_SHORT).show();
    }
}
