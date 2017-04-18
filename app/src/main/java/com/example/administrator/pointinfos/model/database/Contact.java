package com.example.administrator.pointinfos.model.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ${sheldon} on 2017/4/9.
 */
@Entity
public class Contact {
    public static final String TAG = "Contact";
    @Id(autoincrement = true)
    private Long id;

    private String username;

    @Generated(hash = 1642963851)
    public Contact(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    @Generated(hash = 672515148)
    public Contact() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
