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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wlw.zyx.R;
import com.wlw.zyx.adapter.MyPopGridAdapter;
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


/**
 *
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    private ImageView btn_set;
    private DeviceBean deviceBean;
    private FindDeviceBean findDeviceBean;
    private TextView tvClass;
    private RecyclerView rec_f;
    private DeviceRecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView main_rec_SwitchPattern;//情景模式rec
    private SwitchPatternAdapter switchPatternAdapter;//情景模式适配器
    private PopupWindow popupWindow;
    private View popView;
    private GridView popGrid;
    private MyPopGridAdapter myPopGridAdapter;
    private RadioGroup main_radioGroup;
    private Button esc;
    private TextView room;
    private Button sk;
    private Button xk;
    private CheckBox qg;
    private Button adjust_set;

    @Override
    int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        main_rec_SwitchPattern = bindView(R.id.main_rec_SwitchPattern);
        adjust_set=bindView(R.id.adjust_set);
        qg=bindView(R.id.btn_qg);
        sk=bindView(R.id.btn_sk);
        xk=bindView(R.id.btn_xk);
        room = bindView(R.id.main_tv_room);
        esc = bindView(R.id.btn_esc);
        btn_set = bindView(R.id.btn_set);
        tvClass = bindView(R.id.tv_class);
        rec_f = bindView(R.id.rec_f);
        main_radioGroup = bindView(R.id.main_radioGroup);
        rec_f.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        main_rec_SwitchPattern.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
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

                if (isChecked){

                    closeDevice(NetWork.code,"","01");

                }else {


                    closeDevice(NetWork.code,"","00");

                }

            }
        });
        sk.setOnClickListener(this);
        xk.setOnClickListener(this);
        btn_set.setOnClickListener(this);
        esc.setOnClickListener(this);
        main_radioGroup.setOnCheckedChangeListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_set:

             showValidatedialog();

                break;

            case R.id.btn_esc:

                Runtime.getRuntime().exit(0);

                break;

            case R.id.btn_sk://1

                setClass(String.valueOf(deviceBean.getResult().getGlobalPatternList().get(0).getId()));

                break;

            case R.id.btn_xk://2
                setClass(String.valueOf(deviceBean.getResult().getGlobalPatternList().get(1).getId()));
                break;

            case R.id.adjust_set:
                Bundle bundle = new Bundle();
                bundle.putString("code",NetWork.code);
                openActivity(AdjustActivity.class,bundle);

                break;
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ifLoad();
    }

    public void ifLoad(){

        if(null==SharedPreferencesUtils.getParam(this,"code","")){
            toastLong("请先设置班级");
        }else {
            showLoading();
            NetWork.code= (String) SharedPreferencesUtils.getParam(this,"code","");
            getDeviceData();

        }

    }


    public void showValidatedialog(){
        final RxDialogEditSureCancel rxDialogEditSureCancel = new RxDialogEditSureCancel(MainActivity.this);//提示弹窗
        //  rxDialogEditSureCancel.getTitleView().setBackgroundResource(R.drawable.logo);
        rxDialogEditSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rxDialogEditSureCancel.getEditText().getText().toString().equals("123456")){
                    openActivity(SetActivity.class);
                    rxDialogEditSureCancel.cancel();
                }else {
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


    public void getFindDevice(String type, final View view, final int id){
        showLoading();
        OkhttpUtil.okHttpPost(NetWork.FindDeviceUrl+type, new CallBackUtil.CallBackString(){

                    @Override
                    public void onFailure(Call call, Exception e) {
                        Log.e("tag", "onFailure: "+e.getMessage() );
                    }

                    @Override
                    public void onResponse(String response) {
                        findDeviceBean = GsonUtil.GsonToBean(response,FindDeviceBean.class);
                        myPopGridAdapter = new MyPopGridAdapter(MainActivity.this, findDeviceBean,id);
                        popView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_rec,null);
                        popGrid = popView.findViewById(R.id.pop_grid);
                        popGrid.setAdapter(myPopGridAdapter);
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

 public void operateCircuitry(String Status,int id){
     showLoading();
     HashMap<String, String> paramsMap = new HashMap<>();
     paramsMap.put("circuitryId",String.valueOf(id));
     paramsMap.put("status",Status);
     OkhttpUtil.okHttpPost(NetWork.operateCircuitryUrl, paramsMap, new CallBackUtil.CallBackString() {
         @Override
         public void onFailure(Call call, Exception e) {
             Log.e("tag", "onFailure: "+e.getMessage() );
         }

         @Override
         public void onResponse(String response) {
             Log.e("tag", "onResponse: "+response );
             popupWindow.dismiss();
             getDeviceData();
         }
     });
 }
    public void closeDevice(String siteCode, String deviceType, String status){
        showLoading();
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("siteCode",siteCode);
        if(deviceType!=null&&deviceType.length()!=0){
            paramsMap.put("deviceType",deviceType);
        }
        paramsMap.put("status",status);
        OkhttpUtil.okHttpPost(NetWork.operroomcomplexURl, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                getDeviceData();
            }
        });
    }

boolean type = true;

    public void getDeviceData(){

        OkhttpUtil.okHttpPost(NetWork.DeviceUrl+NetWork.code, new CallBackUtil.CallBackString(){

                    @Override
                    public void onFailure(Call call, Exception e) {
                        Log.e("tag", "onFailure: "+e.getMessage() );
                    }

                    @Override
                    public void onResponse(String response) {
                        closeLoading();
                        deviceBean = GsonUtil.GsonToBean(response,DeviceBean.class);
                        tvClass.setText(deviceBean.getResult().getSitepurposeName());
                        recyclerViewAdapter = new DeviceRecyclerViewAdapter(MainActivity.this,deviceBean);
                        rec_f.setAdapter(recyclerViewAdapter);
                        recyclerViewAdapter.refreshData();
                        if(type){
                            switchPatternAdapter = new SwitchPatternAdapter(MainActivity.this,deviceBean);
                            main_rec_SwitchPattern.setAdapter(switchPatternAdapter);
                            switchPatternAdapter.notifyDataSetChanged();
                            type = false;
                        }

                    }
                }
        );

        OkhttpUtil.okHttpPost(NetWork.GetRoomInfoURL+NetWork.code, new CallBackUtil.CallBackString(){

                    @Override
                    public void onFailure(Call call, Exception e) {
                        Log.e("tag", "onFailure: "+e.getMessage() );
                    }

                    @Override
                    public void onResponse(String response) {
                        RoomBean roomBean = new RoomBean();
                        roomBean=GsonUtil.GsonToBean(response,RoomBean.class);
                        room.setText("照明： "+roomBean.getResult().getIllumination()+"Lux        湿度： "+roomBean.getResult().getHumidity()+"%        温度： "+roomBean.getResult().getTemperature()+"℃        PM2.5： "+roomBean.getResult().getPm25()+"μg/m3");

                    }
                }
        );



    }

    public void operateSwitchPattern(String id){
        type = true;
        showLoading();
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("id",id);
        paramsMap.put("status","01");
        OkhttpUtil.okHttpPost(NetWork.OperateSwitchPatternUrl, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                getDeviceData();
            }
        });
    }

    public void setClass(String id){
        showLoading();
        HashMap<String, String> paramsMap = new HashMap<>();
        paramsMap.put("siteCodes",NetWork.code);
        paramsMap.put("id",id);
        paramsMap.put("status","01");
        OkhttpUtil.okHttpPost(NetWork.OperateSwitchPatternUrl, paramsMap, new CallBackUtil.CallBackString() {
            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                getDeviceData();
            }
        });
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){

            case R.id.main_rg_ydms://6
                operateSwitchPattern("27");

                break;

            case R.id.main_rg_bsms://8
                operateSwitchPattern("24");

                break;

            case R.id.main_rg_pptms://9
                operateSwitchPattern("9");
                break;
        }
    }



}
