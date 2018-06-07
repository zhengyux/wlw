package com.wlw.zyx;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.wlw.zyx.util.dialogUtil.LoadingDialogUtils;

public abstract  class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    /***封装toast对象**/
    private  Toast toast;
    /***封装dialog对象**/
    private  Dialog Loadingdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
        initListener();
    }

    // 设置布局
    abstract int setLayout();

    // 初始化组件
    protected abstract void initView();

    // 初始化数据
    protected abstract void initData();

    // 添加监听器
    protected abstract void initListener();

    //绑定控件
    public <T extends View> T bindView(int id){
        return (T)findViewById(id);
    }

    /**
     * 使状态栏透明
     * 适用于图片作为背景的界面，此时需要图片填充到状态栏
     * @param activity 需要设置的activity
     */
    public static void setTranslucent(Activity activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            // 设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 设置根布局的参数
            ViewGroup rootView = (ViewGroup)((ViewGroup)activity
                    .findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }
    }

    //跳转Activity携带bundle
    public void openActivity(Class<?> targetActivityClass, Bundle bundle) {
        Intent intent = new Intent(this, targetActivityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    //跳转Activity不携带bundle
    public void openActivity(Class<?> targetActivityClass) {
        openActivity(targetActivityClass, null);
    }

    //跳转Activity并关闭当前Activity
    public void openActivityAndCloseThis(Class<?> targetActivityClass) {
        openActivity(targetActivityClass);
        this.finish();
    }


    /**
     * 显示长toast
     * @param msg
     */
    public void toastLong(String msg){
        if (null == toast) {
            toast = Toast.makeText(this,msg,Toast.LENGTH_LONG);
        }
            toast.setText(msg);
            toast.show();

    }

    /**
     * 显示短toast
     * @param msg
     */
    public void toastShort(String msg){
        if (null == toast) {
            toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }

    //显示Loading
    public void showLoading(){
        Loadingdialog= LoadingDialogUtils.showWaitDialog(this,"加载中...",false,true);
    }

    //关闭Loading
    public void closeLoading(){
        LoadingDialogUtils.closeDialog(Loadingdialog);
    }


}
