package com.wlw.zyx;


import android.view.View;

import com.wlw.zyx.util.dialogUtil.LoadingDialogUtils;

public class MainActivity extends BaseActivity {


    @Override
    int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setTranslucent(this);
        showLoading();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }


    @Override
    public void onClick(View v) {

    }
}
