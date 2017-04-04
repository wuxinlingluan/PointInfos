package com.example.administrator.pointinfos.model.net.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ${sheldon} on 2017/4/4.
 */

public class FilmBean {

    /**
     * control : {"expires":1800}
     * status : 0
     * data : {"hasNext":false,"movies":[{"sn":0,"showInfo":"今天39家影院放映451场","late":false,"cnms":0,"src":"","showDate":"","sc":8.6,"imax":false,"snum":93699,"preSale":0,"vd":"","dir":"苏有朋","star":"王凯,张鲁一,林心如","cat":"剧情,爱情,悬疑","wish":96194,"3d":false,"ver":"2D/中国巨幕","rt":"2017-03-31上映","dur":112,"img":"http://p1.meituan.net/165.220/movie/1d940cb2aee0a0b53f4977b356a74cb0737745.png","pn":238,"scm":"爱若深入骨，何惧尝其苦","nm":"嫌疑人x的献身","time":"","id":343012},{"sn":0,"showInfo":"今天40家影院放映373场","late":false,"cnms":0,"src":"","showDate":"","sc":8.3,"imax":true,"snum":272562,"preSale":0,"vd":"","dir":"乔丹·沃格特-罗伯茨","star":"汤姆·希德勒斯顿,塞缪尔·杰克逊,约翰·古德曼","cat":"剧情,动作,冒险","wish":85314,"3d":true,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-03-24上映","dur":119,"img":"http://p0.meituan.net/165.220/movie/7bba601685691f8d7c2bf07a1d5af2f6155618.jpg","pn":290,"scm":"金刚一声吼，保家打怪兽","nm":"金刚：骷髅岛","time":"","id":249898},{"sn":0,"showInfo":"2017-04-14 下周五上映","late":false,"cnms":0,"src":"","showDate":"","sc":0,"imax":true,"snum":8890,"preSale":1,"vd":"","dir":"F·加里·格雷","star":"范·迪塞尔,道恩·强森,泰瑞斯·吉布森","cat":"动作,惊悚,犯罪","wish":255461,"3d":true,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"下周五上映","dur":136,"img":"http://p1.meituan.net/165.220/movie/af297f59e363ce96290dfea22f6fea0c153020.jpg","pn":225,"scm":"车王要黑化，家族被击垮","nm":"速度与激情8","time":"","id":248700},{"sn":0,"showInfo":"2017-04-07 本周五上映","late":false,"cnms":0,"src":"","showDate":"","sc":0,"imax":true,"snum":624,"preSale":1,"vd":"","dir":"鲁伯特·山德斯","star":"斯嘉丽·约翰逊,皮鲁·埃斯贝克,萨姆·赖利","cat":"动作,科幻,犯罪","wish":51001,"3d":true,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"本周五上映","dur":107,"img":"http://p0.meituan.net/165.220/movie/70f7bd4ecc4817ccd8d1287cbcf4dbb7772081.jpg","pn":189,"scm":"少佐换嘉丽，攻壳终成立","nm":"攻壳机动队","time":"","id":246969},{"sn":0,"showInfo":"今天39家影院放映243场","late":false,"cnms":0,"src":"","showDate":"","sc":8.7,"imax":false,"snum":23809,"preSale":0,"vd":"","dir":"麦兆辉,潘耀明","star":"黄轩,段奕宏,祖峰","cat":"剧情,动作,犯罪","wish":12949,"3d":false,"ver":"2D/中国巨幕/全景声","rt":"2017-03-31上映","dur":122,"img":"http://p1.meituan.net/165.220/movie/a3b74ced20ccb0e372ee9dc22a4a3772517824.jpg","pn":170,"scm":"潜入贩毒团，卧底破大案","nm":"非凡任务","time":"","id":342906},{"sn":0,"showInfo":"今天40家影院放映196场","late":false,"cnms":0,"src":"","showDate":"","sc":8.4,"imax":false,"snum":18642,"preSale":0,"vd":"","dir":"徐静蕾","star":"白百何,黄立行,明道","cat":"动作,犯罪","wish":21695,"3d":false,"ver":"2D","rt":"2017-03-31上映","dur":95,"img":"http://p1.meituan.net/165.220/movie/b6a6e36d8b40335fc3aeab6953bf18ce322318.jpg","pn":233,"scm":"女儿失踪迹，嫌犯失记忆","nm":"绑架者","time":"","id":344451},{"sn":0,"showInfo":"今天36家影院放映130场","late":false,"cnms":0,"src":"","showDate":"","sc":7.5,"imax":false,"snum":5226,"preSale":0,"vd":"","dir":"让-弗朗科西斯·波利特,François Brisson","star":"Angela Galuppo,张震,Hélène Bourgeois Leclerc","cat":"喜剧,动画","wish":9824,"3d":true,"ver":"2D/3D","rt":"2017-04-01上映","dur":83,"img":"http://p1.meituan.net/165.220/movie/f085eca9158e68ce447fc5d7e47f818c1877485.jpg","pn":57,"scm":"玩雪时间到，打闹变斗殴","nm":"冰雪大作战","time":"","id":346460},{"sn":0,"showInfo":"今天32家影院放映101场","late":false,"cnms":0,"src":"","showDate":"","sc":7.8,"imax":false,"snum":9910,"preSale":0,"vd":"","dir":"王啸坤","star":"范伟,贾静雯,刘俊昊","cat":"剧情,喜剧","wish":19036,"3d":false,"ver":"2D","rt":"2017-04-01上映","dur":99,"img":"http://p0.meituan.net/165.220/movie/5a9847f9263fa069e28cbdad7984844c755880.jpg","pn":149,"scm":"做人别太怂，废柴变英雄","nm":"有完没完","time":"","id":1170252},{"sn":0,"showInfo":"今天24家影院放映98场","late":false,"cnms":0,"src":"","showDate":"","sc":8.2,"imax":true,"snum":181723,"preSale":0,"vd":"","dir":"比尔·康顿","star":"艾玛·沃森,丹·史蒂文斯,卢克·伊万斯","cat":"爱情,奇幻,歌舞","wish":94274,"3d":true,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-03-17上映","dur":130,"img":"http://p1.meituan.net/165.220/movie/acf88770d5b1d548bf8732b0691600a9697009.jpg","pn":220,"scm":"童话永经典，公主美流传","nm":"美女与野兽","time":"","id":247658},{"sn":0,"showInfo":"今天12家影院放映45场","late":false,"cnms":0,"src":"","showDate":"","sc":8.9,"imax":false,"snum":283090,"preSale":0,"vd":"","dir":"拉斯·霍尔斯道姆","star":"布丽特·罗伯森,乔什·盖德,丹尼斯·奎德","cat":"剧情,喜剧","wish":39506,"3d":false,"ver":"2D","rt":"2017-03-03上映","dur":101,"img":"http://p1.meituan.net/165.220/movie/0ec2ddc2bed2bad93017aacc473be337387115.jpg","pn":52,"scm":"狗狗爱主人，重生不离分","nm":"一条狗的使命","time":"","id":342858},{"sn":0,"showInfo":"2017-04-07 本周五上映","late":false,"cnms":0,"src":"","showDate":"","sc":0,"imax":false,"snum":43,"preSale":1,"vd":"","dir":"黄进","star":"余文乐,曾志伟,方皓玟","cat":"剧情","wish":2077,"3d":false,"ver":"2D","rt":"本周五上映","dur":101,"img":"http://p1.meituan.net/165.220/movie/ae29c9c2ee4528046316e15746ebb7ef560801.jpg","pn":24,"scm":"母亲身亡后，父子相处愁","nm":"一念无明","time":"","id":605624},{"sn":0,"showInfo":"今天3家影院放映15场","late":false,"cnms":0,"src":"","showDate":"","sc":9.2,"imax":true,"snum":103585,"preSale":0,"vd":"","dir":"加斯·詹宁斯","star":"马修·麦康纳,董成鹏,瑞茜·威瑟斯彭","cat":"喜剧,动画,音乐","wish":17297,"3d":true,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-02-17上映","dur":108,"img":"http://p0.meituan.net/165.220/movie/2fed2c127078fcca08b075736bf7b69e454069.jpg","pn":125,"scm":"挽救歌剧院，欢唱动物园","nm":"欢乐好声音","time":"","id":344258},{"sn":0,"showInfo":"今天5家影院放映8场","late":false,"cnms":0,"src":"","showDate":"","sc":3.5,"imax":false,"snum":1149,"preSale":0,"vd":"","dir":"陆诗雷","star":"谢容儿,薇拉贝儿,姚雨鑫","cat":"恐怖,惊悚,悬疑","wish":972,"3d":false,"ver":"2D","rt":"2017-04-01上映","dur":87,"img":"http://p1.meituan.net/165.220/movie/e9bcbdaa1ac65306fed0f139c72e0f3c985764.jpg","pn":20,"scm":"梦见已故人，女鬼身缠恨","nm":"怨灵宿舍之白纸女生","time":"","id":345522},{"sn":0,"showInfo":"2017-04-21上映","late":false,"cnms":0,"src":"","showDate":"","sc":0,"imax":false,"snum":720,"preSale":1,"vd":"","dir":"凯利·阿斯博瑞","star":"曼迪·帕廷金,黛米·洛瓦托,雷恩·威尔森","cat":"动画,家庭","wish":89631,"3d":true,"ver":"2D/3D/中国巨幕","rt":"2017-04-21上映","dur":90,"img":"http://p1.meituan.net/165.220/movie/6fa181b782a72ff7cb1ef8aa874e1b7c998470.jpg","pn":75,"scm":"反派格格巫，翻身做男主","nm":"蓝精灵：寻找神秘村","time":"","id":78610},{"sn":0,"showInfo":"今天5家影院放映6场","late":false,"cnms":0,"src":"","showDate":"","sc":7.8,"imax":false,"snum":2100,"preSale":0,"vd":"","dir":"张大磊","star":"孔维一,张晨,郭燕芸","cat":"剧情,家庭","wish":3798,"3d":false,"ver":"2D","rt":"2017-03-24上映","dur":106,"img":"http://p1.meituan.net/165.220/movie/cac3a5565505cd10c04483627c88949d420048.png","pn":44,"scm":"悠然度炎夏，生活却变化","nm":"八月","time":"","id":672178},{"sn":0,"showInfo":"今天4家影院放映5场","late":false,"cnms":0,"src":"","showDate":"","sc":4.5,"imax":false,"snum":26070,"preSale":0,"vd":"","dir":"黎继强","star":"郭德纲,岳云鹏,张小斐","cat":"喜剧","wish":41262,"3d":false,"ver":"2D","rt":"2017-03-24上映","dur":87,"img":"http://p0.meituan.net/165.220/movie/20dfbb84f0c3eff9ab7eea7eb4f55085988323.png","pn":42,"scm":"郭师傅被抓，这事要闹大","nm":"欢乐喜剧人","time":"","id":1156890},{"sn":0,"showInfo":"2014-10-24 下周五重映","late":false,"cnms":0,"src":"","showDate":"","sc":9.4,"imax":false,"snum":20229,"preSale":1,"vd":"","dir":"刘镇伟","star":"周星驰,朱茵,罗家英","cat":"喜剧,爱情,奇幻","wish":50361,"3d":false,"ver":"2D","rt":"下周五上映","dur":110,"img":"http://p1.meituan.net/165.220/movie/f93c377af312b39364da93e85a854756181300.jpg","pn":90,"scm":"紫霞仙寻情,至尊宝娶亲","nm":"大话西游之大圣娶亲","time":"","id":158},{"sn":0,"showInfo":"2017-04-07 本周五上映","late":false,"cnms":0,"src":"","showDate":"","sc":0,"imax":false,"snum":58,"preSale":1,"vd":"","dir":"陈志发","star":"林耀声,廖启智,胡子彤","cat":"剧情,运动","wish":413,"3d":false,"ver":"2D","rt":"本周五上映","dur":96,"img":"http://p1.meituan.net/165.220/movie/c323144132682f5c4af40dfa1d20bc2e110434.jpg","pn":33,"scm":"魔鬼棒球队，逆转出国际","nm":"点五步","time":"","id":346038},{"sn":0,"showInfo":"今天1家影院放映2场","late":false,"cnms":0,"src":"","showDate":"","sc":6.3,"imax":false,"snum":5492,"preSale":0,"vd":"","dir":"谢立文","star":"黄渤,黄秋生,吴君如","cat":"喜剧,动画,家庭","wish":18565,"3d":false,"ver":"2D","rt":"2017-03-17上映","dur":79,"img":"http://p1.meituan.net/165.220/movie/fb6277b3ad96292d0301f5c87607dafa5517413.jpg","pn":48,"scm":"麦兜练武功，对各路英雄","nm":"麦兜响当当","time":"","id":176},{"sn":0,"showInfo":"今天1家影院放映1场","late":false,"cnms":0,"src":"","showDate":"","sc":8.6,"imax":true,"snum":306855,"preSale":0,"vd":"","dir":"詹姆斯·曼高德","star":"休·杰克曼,帕特里克·斯图尔特,达芙妮·基恩","cat":"动作,冒险,科幻","wish":85893,"3d":false,"ver":"2D/IMAX 2D/中国巨幕/全景声","rt":"2017-03-03上映","dur":123,"img":"http://p1.meituan.net/165.220/movie/0b7cc256954866593a8e79009acade71487726.jpg","pn":162,"scm":"狼叔最终战，不舍说再见","nm":"金刚狼3：殊死一战","time":"","id":247875},{"sn":0,"showInfo":"2017-04-07 本周五重映","late":false,"cnms":0,"src":"","showDate":"","sc":8,"imax":false,"snum":327,"preSale":1,"vd":"","dir":"谢立文","star":"张正中,吴君如,许飞","cat":"动画,喜剧","wish":1773,"3d":false,"ver":"2D","rt":"2017-04-02上映","dur":80,"img":"http://p0.meituan.net/165.220/movie/4ac7a5c4ea4b04af1c8705f8876625ba253319.jpg","pn":74,"scm":"学校有困难，卖艺来筹款","nm":"麦兜当当伴我心","time":"","id":641}]}
     */

    private ControlBean control;
    private int status;
    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ControlBean {
        /**
         * expires : 1800
         */

        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        /**
         * hasNext : false
         * movies : [{"sn":0,"showInfo":"今天39家影院放映451场","late":false,"cnms":0,"src":"","showDate":"","sc":8.6,"imax":false,"snum":93699,"preSale":0,"vd":"","dir":"苏有朋","star":"王凯,张鲁一,林心如","cat":"剧情,爱情,悬疑","wish":96194,"3d":false,"ver":"2D/中国巨幕","rt":"2017-03-31上映","dur":112,"img":"http://p1.meituan.net/165.220/movie/1d940cb2aee0a0b53f4977b356a74cb0737745.png","pn":238,"scm":"爱若深入骨，何惧尝其苦","nm":"嫌疑人x的献身","time":"","id":343012},{"sn":0,"showInfo":"今天40家影院放映373场","late":false,"cnms":0,"src":"","showDate":"","sc":8.3,"imax":true,"snum":272562,"preSale":0,"vd":"","dir":"乔丹·沃格特-罗伯茨","star":"汤姆·希德勒斯顿,塞缪尔·杰克逊,约翰·古德曼","cat":"剧情,动作,冒险","wish":85314,"3d":true,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-03-24上映","dur":119,"img":"http://p0.meituan.net/165.220/movie/7bba601685691f8d7c2bf07a1d5af2f6155618.jpg","pn":290,"scm":"金刚一声吼，保家打怪兽","nm":"金刚：骷髅岛","time":"","id":249898},{"sn":0,"showInfo":"2017-04-14 下周五上映","late":false,"cnms":0,"src":"","showDate":"","sc":0,"imax":true,"snum":8890,"preSale":1,"vd":"","dir":"F·加里·格雷","star":"范·迪塞尔,道恩·强森,泰瑞斯·吉布森","cat":"动作,惊悚,犯罪","wish":255461,"3d":true,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"下周五上映","dur":136,"img":"http://p1.meituan.net/165.220/movie/af297f59e363ce96290dfea22f6fea0c153020.jpg","pn":225,"scm":"车王要黑化，家族被击垮","nm":"速度与激情8","time":"","id":248700},{"sn":0,"showInfo":"2017-04-07 本周五上映","late":false,"cnms":0,"src":"","showDate":"","sc":0,"imax":true,"snum":624,"preSale":1,"vd":"","dir":"鲁伯特·山德斯","star":"斯嘉丽·约翰逊,皮鲁·埃斯贝克,萨姆·赖利","cat":"动作,科幻,犯罪","wish":51001,"3d":true,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"本周五上映","dur":107,"img":"http://p0.meituan.net/165.220/movie/70f7bd4ecc4817ccd8d1287cbcf4dbb7772081.jpg","pn":189,"scm":"少佐换嘉丽，攻壳终成立","nm":"攻壳机动队","time":"","id":246969},{"sn":0,"showInfo":"今天39家影院放映243场","late":false,"cnms":0,"src":"","showDate":"","sc":8.7,"imax":false,"snum":23809,"preSale":0,"vd":"","dir":"麦兆辉,潘耀明","star":"黄轩,段奕宏,祖峰","cat":"剧情,动作,犯罪","wish":12949,"3d":false,"ver":"2D/中国巨幕/全景声","rt":"2017-03-31上映","dur":122,"img":"http://p1.meituan.net/165.220/movie/a3b74ced20ccb0e372ee9dc22a4a3772517824.jpg","pn":170,"scm":"潜入贩毒团，卧底破大案","nm":"非凡任务","time":"","id":342906},{"sn":0,"showInfo":"今天40家影院放映196场","late":false,"cnms":0,"src":"","showDate":"","sc":8.4,"imax":false,"snum":18642,"preSale":0,"vd":"","dir":"徐静蕾","star":"白百何,黄立行,明道","cat":"动作,犯罪","wish":21695,"3d":false,"ver":"2D","rt":"2017-03-31上映","dur":95,"img":"http://p1.meituan.net/165.220/movie/b6a6e36d8b40335fc3aeab6953bf18ce322318.jpg","pn":233,"scm":"女儿失踪迹，嫌犯失记忆","nm":"绑架者","time":"","id":344451},{"sn":0,"showInfo":"今天36家影院放映130场","late":false,"cnms":0,"src":"","showDate":"","sc":7.5,"imax":false,"snum":5226,"preSale":0,"vd":"","dir":"让-弗朗科西斯·波利特,François Brisson","star":"Angela Galuppo,张震,Hélène Bourgeois Leclerc","cat":"喜剧,动画","wish":9824,"3d":true,"ver":"2D/3D","rt":"2017-04-01上映","dur":83,"img":"http://p1.meituan.net/165.220/movie/f085eca9158e68ce447fc5d7e47f818c1877485.jpg","pn":57,"scm":"玩雪时间到，打闹变斗殴","nm":"冰雪大作战","time":"","id":346460},{"sn":0,"showInfo":"今天32家影院放映101场","late":false,"cnms":0,"src":"","showDate":"","sc":7.8,"imax":false,"snum":9910,"preSale":0,"vd":"","dir":"王啸坤","star":"范伟,贾静雯,刘俊昊","cat":"剧情,喜剧","wish":19036,"3d":false,"ver":"2D","rt":"2017-04-01上映","dur":99,"img":"http://p0.meituan.net/165.220/movie/5a9847f9263fa069e28cbdad7984844c755880.jpg","pn":149,"scm":"做人别太怂，废柴变英雄","nm":"有完没完","time":"","id":1170252},{"sn":0,"showInfo":"今天24家影院放映98场","late":false,"cnms":0,"src":"","showDate":"","sc":8.2,"imax":true,"snum":181723,"preSale":0,"vd":"","dir":"比尔·康顿","star":"艾玛·沃森,丹·史蒂文斯,卢克·伊万斯","cat":"爱情,奇幻,歌舞","wish":94274,"3d":true,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-03-17上映","dur":130,"img":"http://p1.meituan.net/165.220/movie/acf88770d5b1d548bf8732b0691600a9697009.jpg","pn":220,"scm":"童话永经典，公主美流传","nm":"美女与野兽","time":"","id":247658},{"sn":0,"showInfo":"今天12家影院放映45场","late":false,"cnms":0,"src":"","showDate":"","sc":8.9,"imax":false,"snum":283090,"preSale":0,"vd":"","dir":"拉斯·霍尔斯道姆","star":"布丽特·罗伯森,乔什·盖德,丹尼斯·奎德","cat":"剧情,喜剧","wish":39506,"3d":false,"ver":"2D","rt":"2017-03-03上映","dur":101,"img":"http://p1.meituan.net/165.220/movie/0ec2ddc2bed2bad93017aacc473be337387115.jpg","pn":52,"scm":"狗狗爱主人，重生不离分","nm":"一条狗的使命","time":"","id":342858},{"sn":0,"showInfo":"2017-04-07 本周五上映","late":false,"cnms":0,"src":"","showDate":"","sc":0,"imax":false,"snum":43,"preSale":1,"vd":"","dir":"黄进","star":"余文乐,曾志伟,方皓玟","cat":"剧情","wish":2077,"3d":false,"ver":"2D","rt":"本周五上映","dur":101,"img":"http://p1.meituan.net/165.220/movie/ae29c9c2ee4528046316e15746ebb7ef560801.jpg","pn":24,"scm":"母亲身亡后，父子相处愁","nm":"一念无明","time":"","id":605624},{"sn":0,"showInfo":"今天3家影院放映15场","late":false,"cnms":0,"src":"","showDate":"","sc":9.2,"imax":true,"snum":103585,"preSale":0,"vd":"","dir":"加斯·詹宁斯","star":"马修·麦康纳,董成鹏,瑞茜·威瑟斯彭","cat":"喜剧,动画,音乐","wish":17297,"3d":true,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-02-17上映","dur":108,"img":"http://p0.meituan.net/165.220/movie/2fed2c127078fcca08b075736bf7b69e454069.jpg","pn":125,"scm":"挽救歌剧院，欢唱动物园","nm":"欢乐好声音","time":"","id":344258},{"sn":0,"showInfo":"今天5家影院放映8场","late":false,"cnms":0,"src":"","showDate":"","sc":3.5,"imax":false,"snum":1149,"preSale":0,"vd":"","dir":"陆诗雷","star":"谢容儿,薇拉贝儿,姚雨鑫","cat":"恐怖,惊悚,悬疑","wish":972,"3d":false,"ver":"2D","rt":"2017-04-01上映","dur":87,"img":"http://p1.meituan.net/165.220/movie/e9bcbdaa1ac65306fed0f139c72e0f3c985764.jpg","pn":20,"scm":"梦见已故人，女鬼身缠恨","nm":"怨灵宿舍之白纸女生","time":"","id":345522},{"sn":0,"showInfo":"2017-04-21上映","late":false,"cnms":0,"src":"","showDate":"","sc":0,"imax":false,"snum":720,"preSale":1,"vd":"","dir":"凯利·阿斯博瑞","star":"曼迪·帕廷金,黛米·洛瓦托,雷恩·威尔森","cat":"动画,家庭","wish":89631,"3d":true,"ver":"2D/3D/中国巨幕","rt":"2017-04-21上映","dur":90,"img":"http://p1.meituan.net/165.220/movie/6fa181b782a72ff7cb1ef8aa874e1b7c998470.jpg","pn":75,"scm":"反派格格巫，翻身做男主","nm":"蓝精灵：寻找神秘村","time":"","id":78610},{"sn":0,"showInfo":"今天5家影院放映6场","late":false,"cnms":0,"src":"","showDate":"","sc":7.8,"imax":false,"snum":2100,"preSale":0,"vd":"","dir":"张大磊","star":"孔维一,张晨,郭燕芸","cat":"剧情,家庭","wish":3798,"3d":false,"ver":"2D","rt":"2017-03-24上映","dur":106,"img":"http://p1.meituan.net/165.220/movie/cac3a5565505cd10c04483627c88949d420048.png","pn":44,"scm":"悠然度炎夏，生活却变化","nm":"八月","time":"","id":672178},{"sn":0,"showInfo":"今天4家影院放映5场","late":false,"cnms":0,"src":"","showDate":"","sc":4.5,"imax":false,"snum":26070,"preSale":0,"vd":"","dir":"黎继强","star":"郭德纲,岳云鹏,张小斐","cat":"喜剧","wish":41262,"3d":false,"ver":"2D","rt":"2017-03-24上映","dur":87,"img":"http://p0.meituan.net/165.220/movie/20dfbb84f0c3eff9ab7eea7eb4f55085988323.png","pn":42,"scm":"郭师傅被抓，这事要闹大","nm":"欢乐喜剧人","time":"","id":1156890},{"sn":0,"showInfo":"2014-10-24 下周五重映","late":false,"cnms":0,"src":"","showDate":"","sc":9.4,"imax":false,"snum":20229,"preSale":1,"vd":"","dir":"刘镇伟","star":"周星驰,朱茵,罗家英","cat":"喜剧,爱情,奇幻","wish":50361,"3d":false,"ver":"2D","rt":"下周五上映","dur":110,"img":"http://p1.meituan.net/165.220/movie/f93c377af312b39364da93e85a854756181300.jpg","pn":90,"scm":"紫霞仙寻情,至尊宝娶亲","nm":"大话西游之大圣娶亲","time":"","id":158},{"sn":0,"showInfo":"2017-04-07 本周五上映","late":false,"cnms":0,"src":"","showDate":"","sc":0,"imax":false,"snum":58,"preSale":1,"vd":"","dir":"陈志发","star":"林耀声,廖启智,胡子彤","cat":"剧情,运动","wish":413,"3d":false,"ver":"2D","rt":"本周五上映","dur":96,"img":"http://p1.meituan.net/165.220/movie/c323144132682f5c4af40dfa1d20bc2e110434.jpg","pn":33,"scm":"魔鬼棒球队，逆转出国际","nm":"点五步","time":"","id":346038},{"sn":0,"showInfo":"今天1家影院放映2场","late":false,"cnms":0,"src":"","showDate":"","sc":6.3,"imax":false,"snum":5492,"preSale":0,"vd":"","dir":"谢立文","star":"黄渤,黄秋生,吴君如","cat":"喜剧,动画,家庭","wish":18565,"3d":false,"ver":"2D","rt":"2017-03-17上映","dur":79,"img":"http://p1.meituan.net/165.220/movie/fb6277b3ad96292d0301f5c87607dafa5517413.jpg","pn":48,"scm":"麦兜练武功，对各路英雄","nm":"麦兜响当当","time":"","id":176},{"sn":0,"showInfo":"今天1家影院放映1场","late":false,"cnms":0,"src":"","showDate":"","sc":8.6,"imax":true,"snum":306855,"preSale":0,"vd":"","dir":"詹姆斯·曼高德","star":"休·杰克曼,帕特里克·斯图尔特,达芙妮·基恩","cat":"动作,冒险,科幻","wish":85893,"3d":false,"ver":"2D/IMAX 2D/中国巨幕/全景声","rt":"2017-03-03上映","dur":123,"img":"http://p1.meituan.net/165.220/movie/0b7cc256954866593a8e79009acade71487726.jpg","pn":162,"scm":"狼叔最终战，不舍说再见","nm":"金刚狼3：殊死一战","time":"","id":247875},{"sn":0,"showInfo":"2017-04-07 本周五重映","late":false,"cnms":0,"src":"","showDate":"","sc":8,"imax":false,"snum":327,"preSale":1,"vd":"","dir":"谢立文","star":"张正中,吴君如,许飞","cat":"动画,喜剧","wish":1773,"3d":false,"ver":"2D","rt":"2017-04-02上映","dur":80,"img":"http://p0.meituan.net/165.220/movie/4ac7a5c4ea4b04af1c8705f8876625ba253319.jpg","pn":74,"scm":"学校有困难，卖艺来筹款","nm":"麦兜当当伴我心","time":"","id":641}]
         */

        private boolean hasNext;
        private List<MoviesBean> movies;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            /**
             * sn : 0
             * showInfo : 今天39家影院放映451场
             * late : false
             * cnms : 0
             * src :
             * showDate :
             * sc : 8.6
             * imax : false
             * snum : 93699
             * preSale : 0
             * vd :
             * dir : 苏有朋
             * star : 王凯,张鲁一,林心如
             * cat : 剧情,爱情,悬疑
             * wish : 96194
             * 3d : false
             * ver : 2D/中国巨幕
             * rt : 2017-03-31上映
             * dur : 112
             * img : http://p1.meituan.net/165.220/movie/1d940cb2aee0a0b53f4977b356a74cb0737745.png
             * pn : 238
             * scm : 爱若深入骨，何惧尝其苦
             * nm : 嫌疑人x的献身
             * time :
             * id : 343012
             */

            private int sn;
            private String showInfo;
            private boolean late;
            private int cnms;
            private String src;
            private String showDate;
            private double sc;
            private boolean imax;
            private int snum;
            private int preSale;
            private String vd;
            private String dir;
            private String star;
            private String cat;
            private int wish;
            @SerializedName("3d")
            private boolean _$3d;
            private String ver;
            private String rt;
            private int dur;
            private String img;
            private int pn;
            private String scm;
            private String nm;
            private String time;
            private int id;

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public int getCnms() {
                return cnms;
            }

            public void setCnms(int cnms) {
                this.cnms = cnms;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getShowDate() {
                return showDate;
            }

            public void setShowDate(String showDate) {
                this.showDate = showDate;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public boolean isImax() {
                return imax;
            }

            public void setImax(boolean imax) {
                this.imax = imax;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public String getVd() {
                return vd;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public boolean is_$3d() {
                return _$3d;
            }

            public void set_$3d(boolean _$3d) {
                this._$3d = _$3d;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
