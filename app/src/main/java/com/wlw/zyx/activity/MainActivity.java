package com.wlw.zyx.activity;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.wlw.zyx.R;
import com.wlw.zyx.adapter.FindDeviceBeanGridAdapter;
import com.wlw.zyx.adapter.DeviceRecyclerViewAdapter;
import com.wlw.zyx.adapter.SwitchPatternAdapter;
import com.wlw.zyx.bean.DeviceBean;
import com.wlw.zyx.bean.FindDeviceBean;
import com.wlw.zyx.bean.RoomBean;
import com.wlw.zyx.util.SPUtil.SharedPreferencesUtils;
import com.wlw.zyx.util.dialogUtil.RxDialogEditSureCancel;
import com.wlw.zyx.util.okhttp.CallBackUtil;
import com.wlw.zyx.util.okhttp.GsonUtil;
import com.wlw.zyx.util.okhttp.NetWork;
import com.wlw.zyx.util.okhttp.OkhttpUtil;

import java.util.HashMap;

import okhttp3.Call;
import site.gemus.openingstartanimation.LineDrawStrategy;
import site.gemus.openingstartanimation.OpeningStartAnimation;


/**
 * 主页面
 */
public class MainActivity extends BaseActivity {

    //设置班级按钮
    private ImageView btn_set;
    //设备列表对象
    private DeviceBean deviceBean;
    //设备按钮对象
    private FindDeviceBean findDeviceBean;
    //班级名称
    private TextView tvClass;
    //设备列表
    private RecyclerView rec_f;
    //设备列表适配器
    private DeviceRecyclerViewAdapter recyclerViewAdapter;
    //情景模式列表
    private RecyclerView main_rec_SwitchPattern;
    //情景模式适配器
    private SwitchPatternAdapter switchPatternAdapter;
    //按钮弹窗
    private PopupWindow popupWindow;
    //按钮弹窗的布局
    private View popView;
    //按钮列表
    private GridView popGrid;
    //按钮适配器
    private FindDeviceBeanGridAdapter findDeviceBeanGridAdapter;
    //退出按钮
    private Button esc;
    //温湿度文本
    private TextView room;
    //上课按钮
    private Button sk;
    //下课按钮
    private Button xk;
    //全开全关选择
    private CheckBox qg;
    //温湿度设置按钮
    private Button adjust_set;

    @Override
    int setLayout() {

        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        setOpeningStartAnimation(this);

        main_rec_SwitchPattern = bindView(R.id.main_rec_SwitchPattern);
        adjust_set = bindView(R.id.adjust_set);
        qg = bindView(R.id.btn_qg);
        sk = bindView(R.id.btn_sk);
        xk = bindView(R.id.btn_xk);
        room = bindView(R.id.main_tv_room);
        esc = bindView(R.id.btn_esc);
        btn_set = bindView(R.id.btn_set);
        tvClass = bindView(R.id.tv_class);
        rec_f = bindView(R.id.rec_f);
        rec_f.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        main_rec_SwitchPattern.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }


    @Override
    protected void initData() {

        ifLoad();

    }

    @Override
    protected void initListener() {
        adjust_set.setOnClickListener(this);
        qg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    closeDevice(NetWork.code, "", "01");

                } else {


                    closeDevice(NetWork.code, "", "00");

                }

            }
        });
        sk.setOnClickListener(this);
        xk.setOnClickListener(this);
        btn_set.setOnClickListener(this);
        esc.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_set:

                showValidatedialog();

                break;

            case R.id.btn_esc:

                Runtime.getRuntime().exit(0);

                break;

            case R.id.btn_sk:

                setClass(String.valueOf(deviceBean.getResult().getGlobalPatternList().get(0).getId()), deviceBean.getResult().getGlobalPatternList().get(0).getStatus());

                break;

            case R.id.btn_xk:
                setClass(String.valueOf(deviceBean.getResult().getGlobalPatternList().get(1).getId()), deviceBean.getResult().getGlobalPatternList().get(1).getStatus());
                break;

            case R.id.adjust_set:
                Bundle bundle = new Bundle();
                bundle.putString("code", NetWork.code);
                openActivity(AdjustActivity.class, bundle);

                break;
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ifLoad();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 是否第一次登陆
     */
    public void ifLoad() {

        if ("null".equals(SharedPreferencesUtils.getParam(this, "code", "null"))) {
            toastLong("请先设置班级");
        } else {
            showLoading();
            type = true;
            NetWork.code = (String) SharedPreferencesUtils.getParam(this, "code", "");
            getDeviceData();

        }

    }


    /**
     * 输入密码弹窗
     */
    public void showValidatedialog() {
        final RxDialogEditSureCancel rxDialogEditSureCancel = new RxDialogEditSureCancel(MainActivity.this);//提示弹窗
          rxDialogEditSureCancel.getTitleView().setBackgroundResource(R.mipmap.logo);
        rxDialogEditSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rxDialogEditSureCancel.getEditText().getText().toString().equals("123456")) {
                    openActivity(SetActivity.class);
                    rxDialogEditSureCancel.cancel();
                } else {
                    toastLong("密码错误");
                }
            }
        });
        rxDialogEditSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxDialogEditSureCancel.cancel();
            }
        });
        rxDialogEditSureCancel.show();
    }


    /**
     * 查找设备控制按钮
     *
     * @param type 设备类型
     * @param view 显示位置
     * @param id   设备id
     */
    public void getFindDevice(String type, final View view, final int id, final String status) {
        showLoading();
        OkhttpUtil.okHttpPost(NetWork.FindDeviceUrl + type, new CallBackUtil.CallBackString() {

                    @Override
                    public void onFailure(Call call, Exception e) {
                        closeLoading();
                        toastLong("网络异常："+e.getMessage());
                        Log.e("tag", "onFailure: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response) {
                        findDeviceBean = GsonUtil.GsonToBean(response, FindDeviceBean.class);
                        findDeviceBeanGridAdapter = new FindDeviceBeanGridAdapter(MainActivity.this, findDeviceBean, id, status);
                        popView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_rec, null);
                        popGrid = popView.findViewById(R.id.pop_grid);
                        popGrid.setAdapter(findDeviceBeanGridAdapter);
                        popupWindow = new PopupWindow(popView);
                        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow.setBackgroundDrawable(new BitmapDrawable());
                        popupWindow.setFocusable(true);
                        popupWindow.update();
                        popupWindow.setOutsideTouchable(true);
                        popupWindow.showAsDropDown(view);
                        closeLoading();
                    }

                }
        );
    }

    /**
     * 操控设备
     *
     * @param Status 开关状态码
     * @param id     设备id
     */
    public void operateCircuitry(String Status, int id) {
        showLoading();
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("circuitryId", String.valueOf(id));
        paramsMap.put("status", Status);
        OkhttpUtil.okHttpPost(NetWork.operateCircuitryUrl, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                Log.e("tag", "onFailure: " + e.getMessage());
                closeLoading();
                toastLong("网络异常："+e.getMessage());
            }

            @Override
            public void onResponse(String response) {
                Log.e("tag", "onResponse: " + response);
                popupWindow.dismiss();
                getDeviceData();
            }
        });
    }


    /**
     * 控制全开全关
     *
     * @param siteCode   班级code
     * @param deviceType 设备类型
     * @param status     状态码
     */
    public void closeDevice(String siteCode, String deviceType, String status) {
        showLoading();
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("siteCode", siteCode);
        if (deviceType != null && deviceType.length() != 0) {
            paramsMap.put("deviceType", deviceType);
        }
        paramsMap.put("status", status);
        OkhttpUtil.okHttpPost(NetWork.operroomcomplexURl, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                closeLoading();
                toastLong("网络异常："+e.getMessage());
            }

            @Override
            public void onResponse(String response) {
                getDeviceData();
            }
        });
    }

    boolean type = true;

    /**
     * 获取设备列表和温湿度
     */
    public void getDeviceData() {

        OkhttpUtil.okHttpPost(NetWork.DeviceUrl + NetWork.code, new CallBackUtil.CallBackString() {

                    @Override
                    public void onFailure(Call call, Exception e) {
                        Log.e("tag", "onFailure: " + e.getMessage());
                        closeLoading();
                        toastLong("网络异常："+e.getMessage());
                    }

                    @Override
                    public void onResponse(String response) {
                        closeLoading();
                        deviceBean = GsonUtil.GsonToBean(response, DeviceBean.class);
                        tvClass.setText(deviceBean.getResult().getSitepurposeName());
                        recyclerViewAdapter = new DeviceRecyclerViewAdapter(MainActivity.this, deviceBean);
                        rec_f.setAdapter(recyclerViewAdapter);
                        recyclerViewAdapter.refreshData();

                        if(!deviceBean.getResult().getGlobalPatternList().isEmpty()){
                            if (deviceBean.getResult().getGlobalPatternList().get(0).getStatus().equals("01")) {
                                sk.setBackgroundResource(R.drawable.btn_sk_down);

                            } else {
                                sk.setBackgroundResource(R.drawable.btn_sk_more);

                            }
                            if (deviceBean.getResult().getGlobalPatternList().get(1).getStatus().equals("01")) {
                                xk.setBackgroundResource(R.drawable.btn_xk_down);
                            } else {
                                xk.setBackgroundResource(R.drawable.btn_xk_more);
                            }

                        }

                        if (type) {
                            switchPatternAdapter = new SwitchPatternAdapter(MainActivity.this, deviceBean);
                            main_rec_SwitchPattern.setAdapter(switchPatternAdapter);
                            switchPatternAdapter.notifyDataSetChanged();
                            type = false;
                        }

                    }
                }
        );

        OkhttpUtil.okHttpPost(NetWork.GetRoomInfoURL + NetWork.code, new CallBackUtil.CallBackString() {

                    @Override
                    public void onFailure(Call call, Exception e) {
                        Log.e("tag", "onFailure: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response) {
                        RoomBean roomBean = new RoomBean();
                        roomBean = GsonUtil.GsonToBean(response, RoomBean.class);
                        room.setText("照明： " + roomBean.getResult().getIllumination() + "Lux        湿度： " + roomBean.getResult().getHumidity() + "%        温度： " + roomBean.getResult().getTemperature() + "℃        PM2.5： " + roomBean.getResult().getPm25() + "μg/m3");

                    }
                }
        );


    }

    /**
     * 操控情景模式
     *
     * @param id 情景模式id
     */
    public void operateSwitchPattern(String id, String status) {
        type = true;
        showLoading();
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("siteCodes", NetWork.code);
        paramsMap.put("id", id);
        if (status.equals("00")) {
            paramsMap.put("status", "01");
        } else {
            paramsMap.put("status", "00");
        }

        OkhttpUtil.okHttpPost(NetWork.OperateSwitchPatternUrl, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                closeLoading();
                toastLong("网络异常："+e.getMessage());
            }

            @Override
            public void onResponse(String response) {
                getDeviceData();
            }
        });
    }

    /**
     * 操控上课下课
     *
     * @param id 上下课id
     */
    public void setClass(String id, String status) {
        showLoading();
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("siteCodes", NetWork.code);
        paramsMap.put("id", id);
        if (status.equals("01")) {
            paramsMap.put("status", "00");
        } else {
            paramsMap.put("status", "01");
        }

        OkhttpUtil.okHttpPost(NetWork.OperateSwitchPatternUrl, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {
                closeLoading();
                toastLong("网络异常："+e.getMessage());
            }

            @Override
            public void onResponse(String response) {
                getDeviceData();
            }
        });
    }


}
