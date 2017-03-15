package com.example.administrator.pointinfos.ui.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.dagger.componet.fragment.DaggerBookFragmentComponet;
import com.example.administrator.pointinfos.dagger.module.fragment.BookFragmentModule;
import com.example.administrator.pointinfos.model.net.bean.EverydayReadBean;
import com.example.administrator.pointinfos.presenter.fragment.BookFragmentPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

//每日一文界面
public class BookFragment extends Fragment {

    @Inject
    BookFragmentPresenter bookFragmentPresenter;
    @InjectView(R.id.tv_title)
    AppCompatTextView tvTitle;
    @InjectView(R.id.tv_writer)
    AppCompatTextView tvWriter;
    @InjectView(R.id.tv_content)
    AppCompatTextView tvContent;
    @InjectView(R.id.tv_wc)
    AppCompatTextView tvWc;
    @InjectView(R.id.progressbar)
    ProgressBar progressbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, null);
        DaggerBookFragmentComponet.builder().bookFragmentModule(new BookFragmentModule(this)).build().in(this);
        ButterKnife.inject(this, view);//绑定
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        bookFragmentPresenter.getDate();//获取数据
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    //设置数据
    @TargetApi(Build.VERSION_CODES.N)
    public void success(EverydayReadBean body) {
        EverydayReadBean.DataBean data = body.getData();
        String author = data.getAuthor();//作者
        String content = data.getContent();//内容
        String title = data.getTitle();//名称
        int wc = data.getWc();//字数
        progressbar.setVisibility(View.GONE);//隐藏 加载框
        tvTitle.setText(title);
        tvWriter.setText(author);
        Spanned spanned = Html.fromHtml(content);
        tvContent.setText(spanned);
        tvWc.setText("全书完 共" + wc + "字");
    }
}
