package com.example.administrator.pointinfos.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.pointinfos.model.database.ContactListItem;
import com.example.administrator.pointinfos.widget.ContactListItemView;

import java.util.List;

/**
 * Created by ${sheldon} on 2017/4/10.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactItemViewHolder> {
    public static final String TAG = "ContactListAdapter";

    private Context mContext;
    private List<ContactListItem> mContactListItems;
    private OnItemClickListener mOnItemClickListener;

    public ContactListAdapter(Context context, List<ContactListItem> items) {
        mContext = context;
        mContactListItems = items;
    }

    @Override
    public ContactItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ContactListItemView itemView = new ContactListItemView(mContext);
        return new ContactItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactItemViewHolder holder, int position) {
        final ContactListItem item = mContactListItems.get(position);
        holder.mItemView.bindView(item);
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(item.userName);
                }
            }
        });
        holder.mItemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemLongClick(item.userName);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mContactListItems == null) {
            return 0;
        }
        return mContactListItems.size();
    }

    public class ContactItemViewHolder extends RecyclerView.ViewHolder {

        public ContactListItemView mItemView;

        public ContactItemViewHolder(ContactListItemView itemView) {
            super(itemView);
            mItemView = itemView;
        }
    }

    public List<ContactListItem> getContactListItems() {
        return mContactListItems;
    }


    public interface OnItemClickListener {
        void onItemClick(String name);
        void onItemLongClick(String name);
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        mOnItemClickListener = l;
    }
}
