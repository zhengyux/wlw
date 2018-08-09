package com.wlw.zyx.activity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wlw.zyx.R;
import com.wlw.zyx.adapter.ClassBeanGridViewAdapter;
import com.wlw.zyx.bean.ClassBean;
import com.wlw.zyx.util.SPUtil.SharedPreferencesUtils;
import com.wlw.zyx.util.okhttp.CallBackUtil;
import com.wlw.zyx.util.okhttp.GsonUtil;
import com.wlw.zyx.util.okhttp.NetWork;
import com.wlw.zyx.util.okhttp.OkhttpUtil;

import okhttp3.Call;

/**
 * 设置班级页面
 */
public class SetActivity extends BaseActivity {
    //班级列表
    private GridView gridView;
    //班级对象
    private ClassBean classBean;
    //班级列表适配器
    private ClassBeanGridViewAdapter classBeanGridViewAdapter;
    //班级文本
    private TextView tvClass;
    //确定按钮
    private Button btnOk;
    //班级的code
    private String codes;
    //返回按钮
    private ImageButton back;

    @Override
    int setLayout() {
        return R.layout.activity_set;
    }

    @Override
    protected void initView() {
        gridView = bindView(R.id.grid_class);
        tvClass= bindView(R.id.tv_okclass);
        btnOk = bindView(R.id.btn_set_ok);
        back = bindView(R.id.btn_back);
    }

    @Override
    protected void initData() {
        showLoading();
        getClassData();

    }

    @Override
    protected void initListener() {

        btnOk.setOnClickListener(this);
        back.setOnClickListener(this);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        tvClass.setText("选择班级:  "+classBean.getResult().getData().get(position).getPurposeName());
                        codes = classBean.getResult().getData().get(position).getCodes();
                }
            });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_set_ok:

                SharedPreferencesUtils.setParam(this,"code",codes);
                openActivityAndCloseThis(MainActivity.class);

                break;
            case R.id.btn_back:

                finish();

                break;
        }

    }

    /**
     * 获取班级列表
     */
    public void getClassData(){

        OkhttpUtil.okHttpPost(NetWork.ClassUrl, new CallBackUtil.CallBackString(){

                    @Override
                    public void onFailure(Call call, Exception e) {
                        Log.e("tag", "onFailure: "+e.getMessage() );
                    }

                    @Override
                    public void onResponse(String response) {
                        classBean = GsonUtil.GsonToBean(response,ClassBean.class);
                        classBeanGridViewAdapter = new ClassBeanGridViewAdapter(SetActivity.this,classBean);
                        gridView.setAdapter(classBeanGridViewAdapter);
                        closeLoading();
                    }
                }
        );


    }
}
