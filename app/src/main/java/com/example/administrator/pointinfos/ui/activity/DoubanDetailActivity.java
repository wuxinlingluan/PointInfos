package com.example.administrator.pointinfos.ui.activity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.ui.base.BaseActivity;

import butterknife.InjectView;

/*
* 豆瓣一刻详情
* */
public class DoubanDetailActivity extends BaseActivity {

    @InjectView(R.id.web_view)
    WebView webView;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    private String url;
    private String title;
    private String web;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_douban_detail;
    }

    @Override
    protected void init() {
        super.init();
     //   refreshLayout.setColorSchemeResources(R.color.colorPrimary);
        webView.setScrollbarFadingEnabled(true);
        url = getIntent().getExtras().getString("url");
        title = getIntent().getExtras().getString("title");
        web = getIntent().getExtras().getString("web");
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          //      scrollView.smoothScrollTo(0, 0);
            }
        });

        this.setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setTitle(title);
        //能够和js交互
        webView.getSettings().setJavaScriptEnabled(true);
        //缩放,设置为不能缩放可以防止页面上出现放大和缩小的图标
        webView.getSettings().setBuiltInZoomControls(false);
        //缓存
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //开启DOM storage API功能
        webView.getSettings().setDomStorageEnabled(true);
        //开启application Cache功能
        webView.getSettings().setAppCacheEnabled(false);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return true;
            }

        });
        webView.loadUrl(web);

      //  webView.loadDataWithBaseURL("x-data://base",web,"text/html","utf-8",null);
        //setCollapsingToolbarLayoutTitle(title);
//        Glide.with(getBaseContext())
//                .load(url)
//                .asBitmap()
//                .placeholder(R.drawable.placeholder)
//                .centerCrop()
//                .error(R.drawable.placeholder)
//                .into(imageView);
    }

//    private void setCollapsingToolbarLayoutTitle(String title) {
//        toolbarLayout.setTitle(title);
//        toolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
//        toolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
//        toolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBarPlus1);
//        toolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarPlus1);
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
