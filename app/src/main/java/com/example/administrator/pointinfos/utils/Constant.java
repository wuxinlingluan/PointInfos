package com.example.administrator.pointinfos.utils;

/**
 * Created by Administrator on 2017/3/12.
 */

public interface Constant {
        //每日一文api
    String EVERYDAYAPI="https://interface.meiriyiwen.com/article/today";

    String BASEURL="https://interface.meiriyiwen.com/";
    //新闻API
    String NEWSAPI="http://v.juhe.cn/toutiao/index";
    //微信API
    String WECHARTAPI="http://v.juhe.cn/weixin/query";
    //一席API
    String XIAPI="http://api.yixi.tv/api/v1/album";
    //一席 具体内容
    String YIXIDETAIL="http://api.yixi.tv/api/v1/lecture/detail/";
    //一个具体内容
    String ONEREAD="http://v3.wufazhuce.com:8000/api/channel/reading/more/0";
    //电影数据
    String FILM="http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=1000";
    //豆瓣一刻
    String DOUBANAPI="https://moment.douban.com/api/stream/date/";
    String SP_KEY_USERNAME="username";
    String SP_KEY_PWD="pwd";
    String APK_CONFIG="config.xml";
    String AL_LOGIN="alreadylogin";


    public static class Database {
        public static final String DATABASE_NAME = "qq-db";
    }
}
