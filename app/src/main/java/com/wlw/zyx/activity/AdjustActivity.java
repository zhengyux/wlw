package com.wlw.zyx.activity;

import android.view.View;
import android.widget.Button;

import com.wlw.zyx.R;
import com.wlw.zyx.activity.BaseActivity;
import com.wlw.zyx.util.okhttp.CallBackUtil;
import com.wlw.zyx.util.okhttp.NetWork;
import com.wlw.zyx.util.okhttp.OkhttpUtil;

import java.util.HashMap;

import okhttp3.Call;

public class AdjustActivity extends BaseActivity {

    private Button back;

    private String code;

    @Override
    int setLayout() {
        return R.layout.activity_adjust;
    }

    @Override
    protected void initView() {

        back=bindView(R.id.adjust_btn_back);

    }

    @Override
    protected void initData() {
        code=getIntent().getExtras().getString("code");
        adjustData();
    }

    @Override
    protected void initListener() {

        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.adjust_btn_back:


                break;
        }
    }

    public void adjustData(){
        showLoading();
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("siteCodes",code);
        OkhttpUtil.okHttpPost(NetWork.adjustSetURL, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {

            }
        });
    }

}
