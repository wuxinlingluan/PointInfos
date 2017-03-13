package com.example.administrator.pointinfos.ui.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.dagger.componet.fragment.DaggerBookFragmentComponet;
import com.example.administrator.pointinfos.dagger.module.fragment.BookFragmentModule;
import com.example.administrator.pointinfos.model.net.bean.EverydayReadBean;
import com.example.administrator.pointinfos.presenter.fragment.BookFragmentPresenter;
import com.example.administrator.pointinfos.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class BookFragment extends BaseFragment {

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, null);
        DaggerBookFragmentComponet.builder().bookFragmentModule(new BookFragmentModule(this)).build().in(this);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //   ((TextView)view.findViewById(R.id.tv)).setText("阅读");
    }

    @Override
    public void onResume() {
        super.onResume();
        bookFragmentPresenter.getDate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    @TargetApi(Build.VERSION_CODES.N)
    public void success(EverydayReadBean body) {
        EverydayReadBean.DataBean data = body.getData();
        String author = data.getAuthor();//作者
        String content = data.getContent();//内容
        String title = data.getTitle();//名称
        int wc = data.getWc();//字数

        tvTitle.setText(title);
        tvWriter.setText(author);
        Spanned spanned = Html.fromHtml(content);
        tvContent.setText(spanned);
        tvWc.setText("全书完 共"+wc+"字");
    }
}
