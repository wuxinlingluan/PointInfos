package com.example.administrator.pointinfos.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.ui.base.BaseActivity;
import com.example.administrator.pointinfos.ui.fragment.DoubanFragment;
import com.example.administrator.pointinfos.ui.fragment.FilmFragment;
import com.example.administrator.pointinfos.ui.fragment.HomeFragment;
import com.example.administrator.pointinfos.ui.fragment.MeFragment;

public class MainActivity extends BaseActivity {
    private HomeFragment homeFragment;
    private FilmFragment filmFragment;
    private DoubanFragment doubanFragment;
    private MeFragment    meFragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    initFragmentHome();
                    return true;
                case R.id.navigation_film:
                    initFragmentFilm();
                    return true;
                case R.id.navigation_book:
                    initFragmentBook();
                    return true;
                case R.id.navigation_me:
                     initFragmentMe();
                    return true;
            }
            return false;
        }

    };

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }
    /**
     * 初始化
     * */
    protected void init() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragmentHome();
    }


    /**
        * 初始化首页
        * */
        private void initFragmentHome(){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if(homeFragment == null){
                homeFragment = new HomeFragment();
                transaction.add(R.id.content, homeFragment);
            }
            //隐藏所有fragment
            hideFragment(transaction);
            //显示需要显示的fragment
            transaction.show(homeFragment);
            transaction.commit();
        }
        /**
         * 初始化电影界面
         * */
    private void initFragmentFilm(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(filmFragment == null){
            filmFragment = new FilmFragment();
            transaction.add(R.id.content, filmFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(filmFragment);
        transaction.commit();
    }
    /**
     * 初始化阅读界面
     * */
    private void initFragmentBook(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(doubanFragment == null){
            doubanFragment = new DoubanFragment();
            transaction.add(R.id.content, doubanFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(doubanFragment);
        transaction.commit();
    }
    /**
     * 初始化我的界面
     * */
    private void initFragmentMe(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(meFragment == null){
            meFragment = new MeFragment();
            transaction.add(R.id.content, meFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(meFragment);
        transaction.commit();
    }
    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){
        if(homeFragment != null){
            transaction.hide(homeFragment);
        }
        if(filmFragment != null){
            transaction.hide(filmFragment);
        }
        if(doubanFragment != null){
            transaction.hide(doubanFragment);
        }
        if(meFragment != null){
            transaction.hide(meFragment);
        }
    }


}
