package com.example.administrator.pointinfos.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.model.net.bean.YiXiBean;
import com.example.administrator.pointinfos.presenter.fragment.XiFragmentPresenter;
import com.example.administrator.pointinfos.ui.activity.YiXiDetailActivity;
import com.example.administrator.pointinfos.ui.base.BaseFragment;
import com.example.administrator.pointinfos.utils.IntentUtils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

//一席页面
public class XiFragment extends BaseFragment {
    private List<YiXiBean.DataBean> mDatas = new ArrayList<>();
    private CommonAdapter<YiXiBean.DataBean> commonAdapter;
    @InjectView(R.id.progressbar)
    ProgressBar progressbar;
    @InjectView(R.id.rcl)
    RecyclerView rcl;
    @InjectView(R.id.tkr)
    TwinklingRefreshLayout tkr;
    @Inject
    XiFragmentPresenter xiFragmentPresenter=new XiFragmentPresenter(this);
    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_news;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.inject(this, rootView);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);//设置一行两列
        rcl.setLayoutManager(layoutManager);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        xiFragmentPresenter.getDate();//获取数据
    }
    //数据成功后的处理
    public void success(List<YiXiBean.DataBean> data) {
            if (data!=null){
                progressbar.setVisibility(View.GONE);
                tkr.finishRefreshing();//结束刷新
                tkr.finishLoadmore();
                mDatas=data;
                    commonAdapter=new CommonAdapter<YiXiBean.DataBean>(getActivity(),R.layout.item_yixiinfo,mDatas) {
                        @Override
                        protected void convert(final ViewHolder holder, YiXiBean.DataBean lecturesBean, int position) {
                            holder.setText(R.id.tv_title,mDatas.get(position).getTitle());//设置标题
                            String imgTitle = mDatas.get(position).getLectures().get(0).getCover();
                            String imgHead = mDatas.get(position).getLectures().get(0).getLecturer().getPic();
                            Glide.with(getActivity()).load(imgTitle).asBitmap().into(new SimpleTarget<Bitmap>() {  //解析图片
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                holder.setImageBitmap(R.id.iv_title, resource);//解析大图
                            }
                        });
                            Glide.with(getActivity()).load(imgHead).asBitmap().into(new SimpleTarget<Bitmap>() {  //解析图片
                                @Override
                                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                    holder.setImageBitmap(R.id.civ_title, resource);//解析头像
                                }
                            });
                    }
                    };
                rcl.setAdapter(commonAdapter);
                commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() { //设置item点击事件
                    @Override
                    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                        int id = mDatas.get(position).getLectures().get(0).getId();
                        Bundle bundle = new Bundle();
                        bundle.putString("id", id+"");
                        IntentUtils.changeActivity(getActivity(), YiXiDetailActivity.class, bundle);
                    }

                    @Override
                    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                        return false;
                    }
                });
            }
    };
}
