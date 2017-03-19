package com.example.administrator.pointinfos.ui.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.dagger.componet.activity.DaggerYiXiActivityComponet;
import com.example.administrator.pointinfos.dagger.module.activity.YiXiActivityModule;
import com.example.administrator.pointinfos.model.net.bean.YiXiDetailBean;
import com.example.administrator.pointinfos.presenter.activity.YiXiDetailActivityPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

//一席条目点击activity
public class YiXiDetailActivity extends AppCompatActivity {
    @Inject
    YiXiDetailActivityPresenter yiXiDetailActivityPresenter;
    @InjectView(R.id.iv_head)
    ImageView ivHead;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @InjectView(R.id.tv_content)
    AppCompatTextView tvContent;
    private String url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yi_xi_detail);
        DaggerYiXiActivityComponet.builder().yiXiActivityModule(new YiXiActivityModule(this)).build().in(this);//注入获取对象
        ButterKnife.inject(this);
        Bundle bundle = getIntent().getExtras();
        CharSequence  url1 = bundle.getCharSequence("id");
        init(url1);
    }


    private void init(CharSequence url1) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        yiXiDetailActivityPresenter.getYiXiDetail(url1+"");//获取数据
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }


        //成功后解析数据
    public void success(YiXiDetailBean.DataBean data) {
        if (data!=null){
            String imgHead = data.getBackground();//获取头部图片路径
            Glide.with((this)).load(imgHead).asBitmap().into(new SimpleTarget<Bitmap>() {  //解析图片
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    ivHead.setImageBitmap(resource);//设置头
                }
            });
            collapsingToolbarLayout.setTitle(data.getTitle());//设置标题
            collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
            collapsingToolbarLayout.setCollapsedTitleTextColor(Color.GRAY);//设置收缩后Toolbar上字体的颜色
            collapsingToolbarLayout.setContentScrimColor(0xff1493);
            tvContent.setText(data.getPurecontent());//解析正文
        }
    }
}
