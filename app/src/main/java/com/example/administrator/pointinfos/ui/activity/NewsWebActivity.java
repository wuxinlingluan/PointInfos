package com.example.administrator.pointinfos.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.ui.base.BaseActivity;

public class NewsWebActivity extends BaseActivity {

    private WebView webview;
    private ProgressBar pb_agreement_detail_pager;

    @Override
    protected void init() {
        super.init();
        webview = (WebView) findViewById(R.id.webview);
        pb_agreement_detail_pager = (ProgressBar) findViewById(R.id.pb_agreement_detail_pager);
        Bundle bundle = getIntent().getExtras();
        CharSequence url1 = bundle.getCharSequence("url");
        Intent intent=new Intent();
        String url = intent.getStringExtra("url");
        this.setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setTitle("详情");
        webview.getSettings().setJavaScriptEnabled(true);

        //加载需要显示的网页
        webview.loadUrl(url1.toString());
        //设置Web视图
        webview.setWebViewClient(new HelloWebViewClient ());
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
        }
        return super.onOptionsItemSelected(item);
    }
}
