package com.example.administrator.pointinfos.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.ui.activity.ContactActivity;
import com.example.administrator.pointinfos.ui.base.BaseFragment;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by ${sheldon} on 2017/4/6.
 * 聊天界面
 */
public class ChatFragment extends BaseFragment {
    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.tv_right)
    TextView tvRight;
    @InjectView(R.id.rl)
    RecyclerView rl;
    @InjectView(R.id.twk)
    TwinklingRefreshLayout twk;
    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_chat;
    }
    @Override
    protected void initView() {
        super.initView();
        ivBack.setVisibility(View.GONE);
        title.setText("消息");
        tvRight.setText("联系人");

    }
    @OnClick(R.id.tv_right)
    public void onClick() {
      startActivity(ContactActivity.class,false);
    }
}
