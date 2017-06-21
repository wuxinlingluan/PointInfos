package com.example.administrator.pointinfos.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.ui.base.BaseActivity;

import butterknife.InjectView;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class NewsWebActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    private WebView webview;
    private ProgressBar pb_agreement_detail_pager;
    private String url;
    private String title;
    private CharSequence url1;

    @Override
    protected void init() {
        super.init();
        webview = (WebView) findViewById(R.id.webview);
        pb_agreement_detail_pager = (ProgressBar) findViewById(R.id.pb_agreement_detail_pager);
        Bundle bundle = getIntent().getExtras();
        url1 = bundle.getCharSequence("url");
        Intent intent = new Intent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setTitle("");
        webview.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        webview.loadUrl(url1.toString());
        //设置Web视图
        webview.setWebViewClient(new HelloWebViewClient());
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                pb_agreement_detail_pager.setProgress(newProgress);
                // 加载完毕
                if (newProgress == 100) {
                    pb_agreement_detail_pager.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_news_web;
    }


    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.toolbar_share:
                showShare();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle(title);
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl(url1 + "");
// text是分享文本，所有平台都需要这个字段
        oks.setText(title);
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url1 + "");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        // oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(url1 + "");

// 启动分享GUI
        oks.show(this);
    }
}
