package com.example.administrator.pointinfos.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.model.database.ContactListItem;

import butterknife.InjectView;

/**
 * Created by ${sheldon} on 2017/4/10.
 */

public class ContactListItemView extends RelativeLayout {
    public static final String TAG = "ContactItemView";
    @InjectView(R.id.section)
    TextView mSection;
    @InjectView(R.id.user_name)
    TextView mUserName;


    public ContactListItemView(Context context) {
        this(context, null);
    }

    public ContactListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_contact_item, this);


    }

    public void bindView(ContactListItem contactListItem) {
        mUserName.setText(contactListItem.userName);
        if (contactListItem.showFirstLetter) {
            mSection.setVisibility(VISIBLE);
            mSection.setText(contactListItem.getFirstLetterString());
        } else {
            mSection.setVisibility(GONE);
        }
    }
}
