package com.example.administrator.pointinfos.ui.fragment;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.ui.activity.LoginActivity;
import com.example.administrator.pointinfos.ui.base.BaseFragment;
import com.example.administrator.pointinfos.utils.CachesDataCleanUtils;
import com.example.administrator.pointinfos.utils.CommonUtils;
import com.example.administrator.pointinfos.utils.IntentUtils;
import com.example.administrator.pointinfos.utils.UIUtils;

import butterknife.InjectView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

//我的页面
public class MeFragment extends BaseFragment {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.civ_head)
    CircleImageView civHead;
    @InjectView(R.id.im_phone_arrow)
    ImageView imPhoneArrow;
    @InjectView(R.id.tv_phone_no)
    TextView tvPhoneNo;
    @InjectView(R.id.rl_name)
    RelativeLayout rlName;
    @InjectView(R.id.rl_modify_pwd)
    RelativeLayout rlModifyPwd;
    @InjectView(R.id.im_cache_arrow)
    ImageView imCacheArrow;
    @InjectView(R.id.tv_cache_size)
    TextView tvCacheSize;
    @InjectView(R.id.rl_clean_cache)
    RelativeLayout rlCleanCache;
    @InjectView(R.id.btn_exit_login)
    Button btnExitLogin;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        try {
            String cacheSize = CachesDataCleanUtils.getTotalCacheSize(UIUtils
                    .getContext());
            tvCacheSize.setText(cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @OnClick({R.id.rl_name, R.id.rl_modify_pwd, R.id.rl_clean_cache, R.id.btn_exit_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_name://
             //   Toast.makeText(mActivity, "个人条目", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_modify_pwd:
             //   Toast.makeText(mActivity, "修改密码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_clean_cache:
                showDialog("正在清理缓存");
                UIUtils.getMainHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideDialog();
                        CachesDataCleanUtils.clearAllCache(UIUtils.getContext());
                        try {
                            String totalCacheSize = CachesDataCleanUtils.getTotalCacheSize(UIUtils
                                    .getContext());
                            tvCacheSize.setText(totalCacheSize);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },1000);
                break;
            case R.id.btn_exit_login:
                CommonUtils.cleanUserLoginInfo();
                IntentUtils.changeActivity(getActivity(), LoginActivity.class);
                getActivity().finish();
                break;
        }
    }
}
