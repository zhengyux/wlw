package com.wlw.zyx.util.dialogUtil;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wlw.zyx.R;

/**
 * 项目名称：WLW
 * 类描述：
 * 创建人：xu
 * 创建时间：2018/8/28 14:12
 * 修改人：xu
 * 修改时间：2018/8/28 14:12
 * 修改备注：
 */
public class RxDialogFaceFail extends RxDialog{


    private ImageView mIvLogo;
    private TextView mTvContent;
    private ImageView mIvzhdl;
    private ImageView mIvewmdl;
    private ImageView mIvrlsb;
    private TextView mTvTitle;

    public RxDialogFaceFail(Context context, int themeResId) {
        super(context, themeResId);
        initView();
    }

    public RxDialogFaceFail(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView();
    }

    public RxDialogFaceFail(Context context) {
        super(context);
        initView();
    }

    public RxDialogFaceFail(Activity context) {
        super(context);
        initView();
    }

    public RxDialogFaceFail(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView();
    }

    public ImageView getLogoView() {
        return mIvLogo;
    }

    public void setTitle(String title) {
        mTvTitle.setText(title);
    }

    public TextView getTitleView() {
        return mTvTitle;
    }

    public void setContent(String content) {
        this.mTvContent.setText(content);
    }

    public TextView getContentView() {
        return mTvContent;
    }

    public ImageView getzhdlView() {
        return mIvzhdl;
    }

    public ImageView getrlsbView() {
        return mIvrlsb;
    }

    public ImageView getewmdlView() {
        return mIvewmdl;
    }

    public void setzhdlListener(View.OnClickListener zhdlListener) {
        mIvzhdl.setOnClickListener(zhdlListener);
    }

    public void setewmdlListener(View.OnClickListener cewmdlListener) {
        mIvewmdl.setOnClickListener(cewmdlListener);
    }

    public void setrlsbListener(View.OnClickListener rlsbListener) {
        mIvrlsb.setOnClickListener(rlsbListener);
    }

    private void initView() {
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_face_fail, null);
        mIvLogo = (ImageView) dialogView.findViewById(R.id.iv_logo);
        mIvzhdl = (ImageView) dialogView.findViewById(R.id.iv_zhdl_face_fail_dialog);
        mIvewmdl = (ImageView) dialogView.findViewById(R.id.iv_ewmdl_face_fail_dialog);
        mIvrlsb = (ImageView) dialogView.findViewById(R.id.iv_rlsb_face_fail_dialog);
        mTvContent = (TextView) dialogView.findViewById(R.id.tv_content);
        mTvContent.setTextIsSelectable(true);
        mTvTitle = (TextView) dialogView.findViewById(R.id.tv_title);
        setContentView(dialogView);
    }
}
