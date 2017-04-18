package com.example.administrator.pointinfos.presenter.activity;

import com.example.administrator.pointinfos.model.database.ContactListItem;

import java.util.List;

/**
 * Created by ${sheldon} on 2017/4/9.
 */

public interface ContactPresenter {

    void getContactsFromServer();

    List<ContactListItem> getContactList();

    void refreshContactList();

    void deleteFriend(String name);

}
