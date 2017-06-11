package com.example.administrator.pointinfos.ui.activity

import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.administrator.pointinfos.R
import com.example.administrator.pointinfos.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_douban_detail.*

/*
* 豆瓣一刻详情
* */
class DoubanDetailActivity : BaseActivity() {
   private var url: String? = null
   private var web: String? = null
    override fun getLayoutRes(): Int {
        return R.layout.activity_douban_detail
    }
    override fun init() {
        super.init()
        web_view!!.isScrollbarFadingEnabled = true
        url = intent.extras.getString("url")
        title = intent.extras.getString("title")
        web = intent.extras.getString("web")
        toolbar!!.setOnClickListener {
        }

        this.setSupportActionBar(findViewById(R.id.toolbar) as Toolbar)
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar!!.title = title
        //能够和js交互
        web_view!!.settings.javaScriptEnabled = true
        //缩放,设置为不能缩放可以防止页面上出现放大和缩小的图标
        web_view!!.settings.builtInZoomControls = false
        //缓存
        web_view!!.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        //开启DOM storage API功能
        web_view!!.settings.domStorageEnabled = true
        //开启application Cache功能
        web_view!!.settings.setAppCacheEnabled(false)

        web_view!!.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return true
            }
        })
        web_view!!.loadUrl(web)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
