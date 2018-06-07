package com.wlw.zyx;

import android.view.View;


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
        switch (v.getId()){

        }

    }
}
