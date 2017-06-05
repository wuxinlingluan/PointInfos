package com.example.administrator.pointinfos.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.dagger.componet.fragment.DaggerFilmFragmentComponet;
import com.example.administrator.pointinfos.dagger.module.fragment.FilmFragmentModule;
import com.example.administrator.pointinfos.model.net.bean.FilmBean;
import com.example.administrator.pointinfos.presenter.fragment.FilmFragmentPresenter;
import com.example.administrator.pointinfos.ui.base.BaseFragment;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

//电影界面
public class FilmFragment extends BaseFragment {

    @InjectView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;
    @InjectView(R.id.tkr)
    TwinklingRefreshLayout tkr;
    @InjectView(R.id.rcl)
    RecyclerView rcl;
    @InjectView(R.id.iv_head)
    ImageView ivHead;
    private List<FilmBean.DataBean.MoviesBean> mDatas = new ArrayList<>();
    private CommonAdapter<FilmBean.DataBean.MoviesBean> commonAdapter;
    @Inject
    FilmFragmentPresenter filmFragmentPresenter;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_film;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        rcl.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcl.setHasFixedSize(false);
        rcl.setItemAnimator(new DefaultItemAnimator());
        SinaRefreshView sinaRefreshView=new SinaRefreshView(getActivity());
        LoadingView loadingView=new LoadingView(getActivity());
        tkr.setBottomView(loadingView);
        tkr.setHeaderView(sinaRefreshView);
        DaggerFilmFragmentComponet.builder().filmFragmentModule(new FilmFragmentModule(this)).build().in(this);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        filmFragmentPresenter.getData();
    }

    //获取数据成功
    public void success(List<FilmBean.DataBean.MoviesBean> data) {
        if (data != null) {
            tkr.finishRefreshing();//结束刷新
            mDatas = data;
            commonAdapter = new CommonAdapter<FilmBean.DataBean.MoviesBean>(getActivity(), R.layout.item_film, mDatas) {
                @Override
                protected void convert(final ViewHolder holder, FilmBean.DataBean.MoviesBean moviesBean, int position) {
                    holder.setText(R.id.tv_title, mDatas.get(position).getNm());//电影名
                    holder.setText(R.id.tv_director, "导演: " + mDatas.get(position).getDir());//导演
                    holder.setText(R.id.tv_performer, "主演: " + mDatas.get(position).getStar());//主演
                    holder.setText(R.id.tv_style, "类型: " + mDatas.get(position).getCat());//类型
                    if (mDatas.get(position).getSc() < 1) {
                        holder.setText(R.id.tv_point, "评分: " + "暂无");//评分
                    } else {
                        holder.setText(R.id.tv_point, "评分: " + mDatas.get(position).getSc() + "");//评分
                    }
                    String img = mDatas.get(position).getImg();
                    Glide.with(getActivity()).load(img).asBitmap().into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            holder.setImageBitmap(R.id.iv_icon, resource);//解析海报
                        }
                    });
                }
            };
            rcl.setAdapter(commonAdapter);
            tkr.setOnRefreshListener(new RefreshListenerAdapter() {
                @Override
                public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                    filmFragmentPresenter.getData();
                }

                @Override
                public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                    tkr.finishLoadmore();
                    Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public void fail() {
        Toast.makeText(mActivity, "网络故障,请稍后重试", Toast.LENGTH_SHORT).show();
    }

}
