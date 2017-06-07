package com.example.administrator.pointinfos.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.pointinfos.R;
import com.example.administrator.pointinfos.presenter.activity.impl.RegistPresenterImpl;
import com.example.administrator.pointinfos.presenter.activity.RegistPresenter;
import com.example.administrator.pointinfos.presenter.view.RegistView;
import com.example.administrator.pointinfos.ui.base.BaseActivity;

import butterknife.InjectView;
import butterknife.OnClick;

//注册界面
public class RegisterActivity extends BaseActivity implements TextView.OnEditorActionListener,RegistView {

    @InjectView(R.id.et_username)
    EditText etUsername;
    @InjectView(R.id.et_password)
    EditText etPassword;
    @InjectView(R.id.bt_go)
    Button btGo;
    @InjectView(R.id.cv_add)
    CardView cvAdd;
    @InjectView(R.id.fab)
    FloatingActionButton fab;
    private RegistPresenter registPresenter;
    @Override
    public int getLayoutRes() {
        return R.layout.activity_register;
    }
    @Override
    protected void init() {
        registPresenter=new RegistPresenterImpl(this);
        etPassword.setOnEditorActionListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ShowEnterAnimation();
        }
    }
    private void ShowEnterAnimation() {
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fabtransition);
        getWindow().setSharedElementEnterTransition(transition);

        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                cvAdd.setVisibility(View.GONE);
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                animateRevealShow();
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }


        });
    }

    private void animateRevealShow() {
        Animator mAnimator = ViewAnimationUtils.createCircularReveal(cvAdd, cvAdd.getWidth()/2,0, fab.getWidth() / 2, cvAdd.getHeight());
        mAnimator.setDuration(500);
        mAnimator.setInterpolator(new AccelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                cvAdd.setVisibility(View.VISIBLE);
                super.onAnimationStart(animation);
            }
        });
        mAnimator.start();
    }

    @OnClick({R.id.bt_go, R.id.fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_go://下一步
                register();
                break;
            case R.id.fab://浮动按钮
                animateRevealClose();
                break;
        }
    }

    private void register() {
        String userName = etUsername.getText().toString().trim();
        String pwd = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(userName)||TextUtils.isEmpty(pwd)){
            toast("账号或密码不能为空");
        }else {
            showProgress("正在注册");
            registPresenter.regist(userName,pwd);
        }
    }

    private void animateRevealClose() {
        Animator mAnimator = ViewAnimationUtils.createCircularReveal(cvAdd,cvAdd.getWidth()/2,0, cvAdd.getHeight(), fab.getWidth() / 2);
        mAnimator.setDuration(500);
        mAnimator.setInterpolator(new AccelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cvAdd.setVisibility(View.INVISIBLE);
                super.onAnimationEnd(animation);
                fab.setImageResource(R.drawable.plus);
                RegisterActivity.super.onBackPressed();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        mAnimator.start();
    }
    public void onBackPressed() {
        animateRevealClose();
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (v.getId()==R.id.et_password){
            if (actionId== EditorInfo.IME_ACTION_DONE){
                register();
                return true;
            }
        }
            return false;
    }

    @Override
    public void onRegist(String username, String pwd, boolean isSuccess, String msg) {
            hideProgress();
            if (isSuccess){//注册成功
               saveUser(username,pwd);
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            } else { //注册失败
             showProgress("注册失败");
            }
    }
}
