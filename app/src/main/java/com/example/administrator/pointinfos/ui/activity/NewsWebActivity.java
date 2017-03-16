package com.example.administrator.pointinfos.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.administrator.pointinfos.R;

public class NewsWebActivity extends AppCompatActivity {

    private WebView webview;
    private ImageView iv_back;
    private ProgressBar pb_agreement_detail_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_web);
        webview = (WebView) findViewById(R.id.webview);
        iv_back = (ImageView)findViewById(R.id.iv_back);
        pb_agreement_detail_pager = (ProgressBar) findViewById(R.id.pb_agreement_detail_pager);
        Bundle bundle = getIntent().getExtras();
        CharSequence url1 = bundle.getCharSequence("url");
        Intent intent=new Intent();
        String url = intent.getStringExtra("url");
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
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        return false;
    }
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
