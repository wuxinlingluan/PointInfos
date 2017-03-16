package com.example.administrator.pointinfos.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.ui.fragment.FilmFragment;
import com.example.administrator.pointinfos.ui.fragment.HomeFragment;
import com.example.administrator.pointinfos.ui.fragment.MeFragment;
import com.example.administrator.pointinfos.ui.fragment.XiFragment;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private FilmFragment filmFragment;
    private XiFragment xiFragment;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        init();
    }
    /**
     * 初始化
     * */
    private void init() {
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
        if(xiFragment == null){
            xiFragment = new XiFragment();
            transaction.add(R.id.content, xiFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(xiFragment);
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
        if(xiFragment != null){
            transaction.hide(xiFragment);
        }
        if(meFragment != null){
            transaction.hide(meFragment);
        }
    }
}
