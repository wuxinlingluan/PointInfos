package com.example.administrator.pointinfos.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.util.SnackbarUtils;
import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.dagger.componet.fragment.DaggerDoubanComponet;
import com.example.administrator.pointinfos.dagger.module.fragment.DoubanFragmentModule;
import com.example.administrator.pointinfos.model.net.bean.DoubanBean;
import com.example.administrator.pointinfos.presenter.fragment.DouBanFragmentPresenter;
import com.example.administrator.pointinfos.presenter.view.DoubanView;
import com.example.administrator.pointinfos.ui.activity.DoubanDetailActivity;
import com.example.administrator.pointinfos.ui.base.BaseFragment;
import com.example.administrator.pointinfos.utils.GlideLoader;
import com.example.administrator.pointinfos.utils.IntentUtils;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Created by ${sheldon} on 2017/4/6.
 * 豆瓣一刻
 */
public class DoubanFragment extends BaseFragment implements DoubanView{

    @InjectView(R.id.iv_head)
    ImageView ivHead;
    @InjectView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.rcl)
    RecyclerView rcl;
    @InjectView(R.id.tkr)
    TwinklingRefreshLayout tkr;
    private CommonAdapter<DoubanBean.PostsBean> commonAdapter;
    private List<DoubanBean.PostsBean> mData=new ArrayList<>();
    @Inject
     DouBanFragmentPresenter douBanFragmentPresenter; //初始化
    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_douban;
    }
    @Override
    public void initView() {
        rcl.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcl.setHasFixedSize(true);
        SinaRefreshView sinaRefreshView=new SinaRefreshView(getActivity());
        tkr.setHeaderView(sinaRefreshView);
        tkr.setEnableLoadmore(false);
        DaggerDoubanComponet.builder().doubanFragmentModule(new DoubanFragmentModule(this)).build().in(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        douBanFragmentPresenter.getData(); //获取数据
    }
    @Override
    public void showData(List<DoubanBean> bean) {
        if (bean!=null){
           tkr.finishRefreshing();
           mData= bean.get(0).getPosts();
            commonAdapter=new CommonAdapter<DoubanBean.PostsBean>(getActivity(),R.layout.item_douban,mData) {
                @Override
                protected void convert(ViewHolder holder, DoubanBean.PostsBean postsBean, int position) {
                    ImageView  imageView=   holder.getView(R.id.im_cover);
                    holder.setText(R.id.tv_title,mData.get(position).getTitle());
                    holder.setText(R.id.tv_time,mData.get(position).getPublished_time());
                    if (mData.get(position).getThumbs().size()>0){
                       GlideLoader.load(getActivity(),mData.get(position).getThumbs().get(0).getSmall().getUrl(),imageView);
                    } else {
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.icon_douban));
                    }

                }
            };
            rcl.setAdapter(commonAdapter);
            tkr.setOnRefreshListener(new RefreshListenerAdapter() {
                @Override
                public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                    super.onRefresh(refreshLayout);
                    douBanFragmentPresenter.getData(); //获取数据
                }
            });
            commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    String url="";
                    if (mData.get(position).getThumbs().size()==0){
                        url="";
                    }else {
                       url = mData.get(position).getThumbs().get(0).getMedium().getUrl();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("url", url);
                    bundle.putString("web", mData.get(position).getUrl());
                    bundle.putString("title", mData.get(position).getTitle());
                    IntentUtils.changeActivity(getActivity(), DoubanDetailActivity.class, bundle);
                }

                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                    return false;
                }
            });
        }
    }
    @Override
    public void showProgressBar() {
        showDialog("正在加载");
    }
    @Override
    public void hideProgressBar() {
        hideDialog();
    }
    @Override
    public void showeFailure() {
        SnackbarUtils.showShort(rcl,"加载失败", Color.WHITE,Color.TRANSPARENT);
    }

}
