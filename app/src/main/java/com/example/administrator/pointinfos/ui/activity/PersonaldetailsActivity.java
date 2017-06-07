package com.example.administrator.pointinfos.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.ui.base.BaseActivity;
import com.example.administrator.pointinfos.utils.IntentUtils;

import butterknife.InjectView;
import butterknife.OnClick;

/*
* 关于界面
* */
public class PersonaldetailsActivity extends BaseActivity {
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tv_github)
    TextView tvGithub;
    @InjectView(R.id.tv_prject)
    TextView tvPrject;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_personaldetails;
    }

    @Override
    protected void init() {
        super.init();
        this.setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setTitle("关于我");
    }

    @OnClick({R.id.tv_github, R.id.tv_prject})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_github:
                Bundle bundle = new Bundle();
                bundle.putString("url", "https://github.com/wuxinlingluan");
                IntentUtils.changeActivity(this, NewsWebActivity.class, bundle);
                break;
            case R.id.tv_prject:
                Bundle bundle2 = new Bundle();
                bundle2.putString("url", "https://github.com/wuxinlingluan/PointInfos");
                IntentUtils.changeActivity(this, NewsWebActivity.class, bundle2);
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
