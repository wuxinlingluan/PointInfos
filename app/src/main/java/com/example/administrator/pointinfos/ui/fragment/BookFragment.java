package com.example.administrator.pointinfos.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.presenter.fragment.BookFragmentPresenter;
import com.example.administrator.pointinfos.ui.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class BookFragment extends BaseFragment {
    @InjectView(R.id.tv_title)
    AppCompatTextView tvTitle;
    @InjectView(R.id.tv_writer)
    AppCompatTextView tvWriter;
    @InjectView(R.id.tv_content)
    AppCompatTextView tvContent;
    BookFragmentPresenter bookFragmentPresenter=new BookFragmentPresenter();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, null);
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
}
