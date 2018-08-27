package com.wlw.zyx.activity;

import android.view.View;
import android.widget.Button;

import com.wlw.zyx.R;
import com.wlw.zyx.util.okhttp.CallBackUtil;
import com.wlw.zyx.util.okhttp.NetWork;
import com.wlw.zyx.util.okhttp.OkhttpUtil;

import java.util.HashMap;

import okhttp3.Call;

public class AdjustActivity extends BaseActivity {


    @Override
    int setLayout() {
        return R.layout.activity_adjust;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {
        adjustData();
    }

    @Override
    protected void initListener() {

    }



    public void adjustData(){
        showLoading();
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("siteCodes",NetWork.code);
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
