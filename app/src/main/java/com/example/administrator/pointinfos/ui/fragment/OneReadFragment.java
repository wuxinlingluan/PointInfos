package com.example.administrator.pointinfos.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.model.net.bean.OneReadBean;
import com.example.administrator.pointinfos.presenter.fragment.OneReadFragmentPresenter;
import com.example.administrator.pointinfos.ui.activity.NewsWebActivity;
import com.example.administrator.pointinfos.ui.base.BaseFragment;
import com.example.administrator.pointinfos.utils.IntentUtils;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

//一个阅读界面
public class OneReadFragment extends BaseFragment {
    private List<OneReadBean.DataBean> mDatas=new ArrayList<>();
    private CommonAdapter<OneReadBean.DataBean> commonAdapter;
    @InjectView(R.id.rcl)
    RecyclerView rcl;
    @InjectView(R.id.tkr)
    TwinklingRefreshLayout tkr;
    @Inject
    OneReadFragmentPresenter oneReadFragmentPresenter=new OneReadFragmentPresenter(this);
    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_news;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
    public void success(List<OneReadBean.DataBean> data) {
            if (data!=null){
                tkr.finishRefreshing();//结束刷新
                mDatas=data;
                commonAdapter=new CommonAdapter<OneReadBean.DataBean>(getActivity(),R.layout.item_oneread,mDatas) {
                    @Override
                    protected void convert(final ViewHolder holder, OneReadBean.DataBean dataBean, int position) {
                        holder.setText(R.id.tv_title,mDatas.get(position).getTitle());//设置标题
                        holder.setText(R.id.tv_writer,"文/"+mDatas.get(position).getAuthor().getUser_name());//设置写手
                        holder.setText(R.id.tv_info,mDatas.get(position).getForward());//设置简介
                        holder.setText(R.id.tv_time,mDatas.get(position).getLast_update_date());//设置时间
                        String img_url_big = mDatas.get(position).getImg_url();//大图
                        String img_url_small = mDatas.get(position).getAuthor().getWeb_url();//小图
                        Glide.with(getActivity()).load(img_url_big).asBitmap().into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                holder.setImageBitmap(R.id.iv_title,resource);//解析大图
                            }
                        });
                        Glide.with(getActivity()).load(img_url_small).asBitmap().into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                holder.setImageBitmap(R.id.civ_title,resource);//解析小图
                            }
                        });
                    }
                };
                rcl.setAdapter(commonAdapter);
                commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                        String share_url = mDatas.get(position).getShare_url();//web页面
                        Bundle bundle = new Bundle();
                        bundle.putString("url", share_url);
                        IntentUtils.changeActivity(getActivity(), NewsWebActivity.class, bundle);
                    }

                    @Override
                    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                        return false;
                    }
                });
                tkr.setOnRefreshListener(new RefreshListenerAdapter() {
                    @Override
                    public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                        oneReadFragmentPresenter.getData();
                    }

                    @Override
                    public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                        tkr.finishLoadmore();
                        Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                    }
                });
            }
    }
    //获取数据失败
    public void fail() {
        Toast.makeText(mActivity, "获取数据失败,请稍后再试", Toast.LENGTH_SHORT).show();
    }
}
