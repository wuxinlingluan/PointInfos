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
import com.example.administrator.pointinfos.dagger.componet.fragment.DaggerWechartFragmentComponet;
import com.example.administrator.pointinfos.dagger.module.fragment.WechartFragmentModule;
import com.example.administrator.pointinfos.model.net.bean.WeChartBean;
import com.example.administrator.pointinfos.presenter.fragment.WechartFragmentPresenter;
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

//微信界面
public class WechartFragment extends BaseFragment {
//    @InjectView(R.id.progressbar)
//    ProgressBar progressbar;
    private int pageNum; //页码
    private CommonAdapter<WeChartBean.ResultBean.ListBean> commonAdapter;
    private List<WeChartBean.ResultBean.ListBean> mDatas = new ArrayList<>();
    @Inject
    WechartFragmentPresenter wechartFragmentPresenter;
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
        rcl.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcl.setHasFixedSize(true);
        DaggerWechartFragmentComponet.builder().wechartFragmentModule(new WechartFragmentModule(this)).build().in(this);//获取对象
        return rootView;
    }

    //获取数据
    @Override
    public void onResume() {
        super.onResume();
        pageNum = 1;
        wechartFragmentPresenter.getDate(pageNum);//获取数据
    }

    //数据返回
    public void success(WeChartBean.ResultBean result) {
        if (result != null) {
           // progressbar.setVisibility(View.GONE);
         //   tkr.finishRefreshing();
        //    tkr.finishLoadmore();
            if (pageNum == 1) { //第一页数据
                mDatas = result.getList();
                commonAdapter = new CommonAdapter<WeChartBean.ResultBean.ListBean>(getActivity(), R.layout.item_newslist, mDatas) {
                    @Override
                    protected void convert(final ViewHolder holder, WeChartBean.ResultBean.ListBean listBean, int position) {
                        holder.setText(R.id.tv_news_title, mDatas.get(position).getTitle());//设置数据
                        holder.setText(R.id.tv_new_from, "来源:" + mDatas.get(position).getSource());
                        String thumbnail_pic_s = mDatas.get(position).getFirstImg();
                        Glide.with(getActivity()).load(thumbnail_pic_s).asBitmap().into(new SimpleTarget<Bitmap>() {  //解析图片
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                holder.setImageBitmap(R.id.iv_news_icon, resource);
                            }
                        });
                    }
                };
                rcl.setAdapter(commonAdapter);
            } else { //加载更多
                List<WeChartBean.ResultBean.ListBean> moredatas = result.getList();
                if (!moredatas.isEmpty()) {
                    mDatas.addAll(moredatas);
                    Toast.makeText(getActivity(), "加载成功", Toast.LENGTH_SHORT).show();
                    rcl.getAdapter().notifyDataSetChanged();
                }
            }
            commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
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
        }
        tkr.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                pageNum = 1;
                wechartFragmentPresenter.getDate(pageNum);//设置下拉刷新
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                pageNum++;
                wechartFragmentPresenter.getDate(pageNum);//设置上拉加载数据
            }
        });
    }

}
