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
import com.example.administrator.pointinfos.dagger.componet.fragment.DaggerNewsFragmentComponet;
import com.example.administrator.pointinfos.dagger.module.fragment.NewsFragmentModule;
import com.example.administrator.pointinfos.model.net.bean.NewsBean;
import com.example.administrator.pointinfos.presenter.fragment.NewsFragmentPresenter;
import com.example.administrator.pointinfos.ui.activity.NewsWebActivity;
import com.example.administrator.pointinfos.ui.base.BaseFragment;
import com.example.administrator.pointinfos.utils.IntentUtils;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

//新闻界面
public class NewsFragment extends BaseFragment {
    private List<NewsBean.ResultBean.DataBean> mDatas = new ArrayList<>();
    private CommonAdapter<NewsBean.ResultBean.DataBean> commonAdapter;
    @InjectView(R.id.rcl)
    RecyclerView rcl;
    @InjectView(R.id.tkr)
    TwinklingRefreshLayout tkr;
    @Inject
    NewsFragmentPresenter newsFragmentPresenter;

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
        SinaRefreshView sinaRefreshView=new SinaRefreshView(getActivity());
        LoadingView loadingView=new LoadingView(getActivity());
        tkr.setBottomView(loadingView);
        tkr.setHeaderView(sinaRefreshView);
        DaggerNewsFragmentComponet.builder().newsFragmentModule(new NewsFragmentModule(this)).build().in(this);//注入获取对象
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        newsFragmentPresenter.getDate();//获取数据
    }

    public void success(NewsBean.ResultBean result) {
        if (result != null) {
            tkr.finishRefreshing();//结束刷新
            mDatas = result.getData();
            commonAdapter = new CommonAdapter<NewsBean.ResultBean.DataBean>(getActivity(), R.layout.item_newslist, mDatas) {
                @Override
                protected void convert(final ViewHolder holder, NewsBean.ResultBean.DataBean dataBean, int position) {
                    holder.setText(R.id.tv_news_title, mDatas.get(position).getTitle());//设置数据
                    holder.setText(R.id.tv_new_from, "来源:" + mDatas.get(position).getAuthor_name());
                    holder.setText(R.id.tv_news_time, mDatas.get(position).getDate());
                    String thumbnail_pic_s = mDatas.get(position).getThumbnail_pic_s();
                    Glide.with(getActivity()).load(thumbnail_pic_s).asBitmap().into(new SimpleTarget<Bitmap>() {  //解析图片
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            holder.setImageBitmap(R.id.iv_news_icon, resource);
                        }
                    });
                }
            };
            rcl.setAdapter(commonAdapter);
            commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {  //条目点击
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    String url = mDatas.get(position).getUrl();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", url);
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
                    newsFragmentPresenter.getDate();//获取数据
                }

                @Override
                public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                    tkr.finishLoadmore();
                    Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
