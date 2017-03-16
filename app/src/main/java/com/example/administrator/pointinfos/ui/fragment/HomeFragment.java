package com.example.administrator.pointinfos.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.pointinfos.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

//主页界面
public class HomeFragment extends Fragment{
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tabs)
    TabLayout tabs;
    @InjectView(R.id.vp)
    ViewPager vp;
    private String[] titles = new String[]{"每日新闻", "微信精选", "每日笑话", "每日一文"};//首页 viewpager名称
    private MyAdaper adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.inject(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter=new MyAdaper(getFragmentManager());
        vp.setAdapter(adapter);
        tabs.setupWithViewPager(vp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
    //设置adapter
    private class MyAdaper extends FragmentPagerAdapter {

        public MyAdaper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            switch (position){
                case 0:
                    fragment=new NewsFragment();//新闻界面
                    break;
                case 1:
                    fragment=new WechartFragment();//微信
                    break;
                case 2:
                    fragment=new JokeFragment();//笑话
                    break;
                case 3:
                    fragment=new BookFragment();//每日一文
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
