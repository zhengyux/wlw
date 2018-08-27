package com.wlw.zyx.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.wlw.zyx.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForggetPwdActivity extends BaseActivity {


    @BindView(R.id.iv_back_forgetpwd)
    ImageView ivBackForgetpwd;//返回
    @BindView(R.id.et_phone_forgetpwd)
    EditText etPhoneForgetpwd;//手机号
    @BindView(R.id.et_identifying_code_forgetpwd)
    EditText etIdentifyingCodeForgetpwd;//验证码
    @BindView(R.id.btn_getcode_forgetpwd)
    Button btnGetcodeForgetpwd;//获取验证码
    @BindView(R.id.btn_next_step_forgetpwd)
    Button btnNextStepForgetpwd;//下一步

    @Override
    int setLayout() {
        return R.layout.activity_forgget_pwd;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.iv_back_forgetpwd, R.id.btn_getcode_forgetpwd, R.id.btn_next_step_forgetpwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_forgetpwd:
                finish();
                break;
            case R.id.btn_getcode_forgetpwd:
                countDownTimer.start();
                btnGetcodeForgetpwd.setEnabled(false);
                break;
            case R.id.btn_next_step_forgetpwd:
                openActivity(ForggetPwdSureActivity.class);
                break;
        }
    }


    /**
     * 倒计时
     */
    CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            String value = String.valueOf((int) (millisUntilFinished / 1000));
            btnGetcodeForgetpwd.setText(value);
        }

        @Override
        public void onFinish() {
            btnGetcodeForgetpwd.setText(getResources().getString(R.string.getcode));
            btnGetcodeForgetpwd.setEnabled(true);
        }
    };
}
