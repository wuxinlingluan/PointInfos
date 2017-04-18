package com.example.administrator.pointinfos.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.model.database.ContactListItem;
import com.example.administrator.pointinfos.presenter.activity.ContactPresenter;
import com.example.administrator.pointinfos.presenter.activity.ContactPresenterImpl;
import com.example.administrator.pointinfos.presenter.activity.ContactView;
import com.example.administrator.pointinfos.ui.adapter.ContactListAdapter;
import com.example.administrator.pointinfos.ui.adapter.EMContactListenerAdapter;
import com.example.administrator.pointinfos.ui.base.BaseActivity;
import com.example.administrator.pointinfos.widget.SlideBar;
import com.hyphenate.chat.EMClient;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static com.baidu.mapapi.BMapManager.getContext;

//联系人界面
public class ContactActivity extends BaseActivity implements ContactView {
    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.tv_right)
    TextView tvRight;
    @InjectView(R.id.recycler_view)
    RecyclerView recyclerView;
    @InjectView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @InjectView(R.id.slide_bar)
    SlideBar mSlideBar;
    @InjectView(R.id.section)
    TextView mSection;
    private ContactPresenter mContactPresenter;
    private ContactListAdapter mContactListAdapter;
    private int POSITION_NOT_FOUND=-1;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_contact;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        getLayoutRes();
        ButterKnife.inject(this);
        init();
    }

    @Override
    protected void init() {
        super.init();
        initView();
        mContactPresenter=new ContactPresenterImpl(this);
        EMClient.getInstance().contactManager().setContactListener(mEMContactListener);
        mContactPresenter.getContactsFromServer();
    }

    private void initView() {
        ivBack.setVisibility(View.GONE);
        title.setText("联系人");
        tvRight.setText("添加");
        initRecyclerView();
        mSwipeRefreshLayout.setColorSchemeResources(R.color.qq_blue, R.color.qq_red);
        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);
        mSlideBar.setOnSlidingBarChangeListener(mOnSlideBarChangeListener);
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mContactListAdapter = new ContactListAdapter(this, mContactPresenter.getContactList());
        mContactListAdapter.setOnItemClickListener(mOnItemClickListener);
        recyclerView.setAdapter(mContactListAdapter);
    }
    private SlideBar.OnSlideBarChangeListener mOnSlideBarChangeListener = new SlideBar.OnSlideBarChangeListener() {
        @Override
        public void onSectionChange(int index, String section) {
            mSection.setVisibility(View.VISIBLE);
            mSection.setText(section);
            scrollToSection(section);
        }

        @Override
        public void onSlidingFinish() {
            mSection.setVisibility(View.GONE);
        }
    };


    @OnClick(R.id.tv_right)
    public void onClick() {
        toast("添加联系人界面");
    }

    @Override
    public void onGetContactListSuccess() {
        mContactListAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onGetContactListFailed() {
        toast(getString(R.string.get_contacts_error));
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDeleteFriendSuccess() {
        hideProgress();
        toast(getString(R.string.delete_friend_success));
        mContactPresenter.refreshContactList();
    }

    @Override
    public void onDeleteFriendFailed() {
        hideProgress();
        toast(getString(R.string.delete_friend_failed));
    }
    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mContactPresenter.refreshContactList();
        }
    };

    private EMContactListenerAdapter mEMContactListener = new EMContactListenerAdapter() {

        @Override
        public void onContactAdded(String s) {
            mContactPresenter.refreshContactList();
        }

        @Override
        public void onContactDeleted(String s) {
            mContactPresenter.refreshContactList();
        }
    };


    /**
     * RecyclerView滚动直到界面出现对应section的联系人
     *
     * @param section 首字符
     */
    private void scrollToSection(String section) {
        int sectionPosition = getSectionPosition(section);
        if (sectionPosition != POSITION_NOT_FOUND) {
            recyclerView.smoothScrollToPosition(sectionPosition);
        }
    }


    /**
     *
     * @param section 首字符
     * @return 在联系人列表中首字符是section的第一个联系人在联系人列表中的位置
     */
    private int getSectionPosition(String section) {
        List<ContactListItem> contactListItems = mContactListAdapter.getContactListItems();
        for (int i = 0; i < contactListItems.size(); i++) {
            if (section.equals(contactListItems.get(i).getFirstLetterString())) {
                return i;
            }
        }
        return POSITION_NOT_FOUND;
    }

    private ContactListAdapter.OnItemClickListener mOnItemClickListener = new ContactListAdapter.OnItemClickListener() {

        /**
         * 单击跳转到聊天界面
         * @param name 点击item的联系人名字
         */
        @Override
        public void onItemClick(String name) {
      //      startActivity(ChatActivity.class, Constant.Extra.USER_NAME, name);
            toast("点击聊天");
        }

        /**
         * 长按删除好友
         * @param name 点击item的联系人名字
         */
        @Override
        public void onItemLongClick(final String name) {
            showDeleteFriendDialog(name);
        }
    };
    private void showDeleteFriendDialog(final String name) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String message = String.format(getString(R.string.delete_friend_message), name);
        builder.setTitle(getString(R.string.delete_friend))
                .setMessage(message)
                .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        showProgress(getString(R.string.deleting_friend));
                        mContactPresenter.deleteFriend(name);

                    }
                });
        builder.show();
    }
}
