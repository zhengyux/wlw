package com.wlw.zyx.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wlw.zyx.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_phone_login)
    EditText etPhoneLogin;//帐号输入框
    @BindView(R.id.et_password_login)
    EditText etPasswordLogin;//密码输入框
    @BindView(R.id.tv_forgetpwd_login)
    TextView tvForgetpwdLogin;//忘记密码
    @BindView(R.id.btn_login_login)
    Button btnLoginLogin;//登录
    @BindView(R.id.iv_face_login)
    ImageView ivFaceLogin;//人脸识别
    @BindView(R.id.iv_code_login)
    ImageView ivCodeLogin;//二维码登录

    @Override
    int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        setOpeningStartAnimation(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initListener() {

    }


    @OnClick({R.id.tv_forgetpwd_login, R.id.btn_login_login, R.id.iv_face_login, R.id.iv_code_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_forgetpwd_login:
                openActivity(ForggetPwdActivity.class);
                break;
            case R.id.btn_login_login:
                openActivityAndCloseThis(MainActivity.class);
                break;
            case R.id.iv_face_login:
                break;
            case R.id.iv_code_login:
                break;
        }
    }
}

