package com.example.administrator.pointinfos.model.database;

import com.example.administrator.pointinfos.R;

/**
 * Created by ${sheldon} on 2017/4/9.
 */

public class ContactListItem {
    public static final String TAG = "ContactListItem";
    public int avatar = R.mipmap.icon_me;

    public String userName;

    public boolean showFirstLetter = true;

    public char getFirstLetter() {
        return userName.charAt(0);
    }

    public String getFirstLetterString() {
        return String.valueOf(getFirstLetter()).toUpperCase();
    }
}
