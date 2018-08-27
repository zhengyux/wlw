package com.wlw.zyx.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.wlw.zyx.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForggetPwdSureActivity extends BaseActivity {


    @BindView(R.id.iv_back_forgetpwdsure)
    ImageView ivBackForgetpwdsure;
    @BindView(R.id.et_phone_forgetpwdsure)
    EditText etPhoneForgetpwdsure;
    @BindView(R.id.btn_next_step_forgetpwdsure)
    Button btnNextStepForgetpwdsure;

    @Override
    int setLayout() {
        return R.layout.activity_forgget_pwd_sure;
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


    @OnClick({R.id.iv_back_forgetpwdsure, R.id.btn_next_step_forgetpwdsure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_forgetpwdsure:
                finish();
                break;
            case R.id.btn_next_step_forgetpwdsure:
                break;
        }
    }
}
