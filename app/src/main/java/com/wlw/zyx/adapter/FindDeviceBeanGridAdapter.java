package com.wlw.zyx.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;


import com.wlw.zyx.activity.MainActivity;
import com.wlw.zyx.R;
import com.wlw.zyx.bean.FindDeviceBean;

/**
 * 设备按钮适配器
 */
public class FindDeviceBeanGridAdapter extends BaseAdapter {

    private MainActivity mContext;
    private FindDeviceBean findDeviceBean;
    private int id;
    private String status;

    public FindDeviceBeanGridAdapter(MainActivity mContext, FindDeviceBean findDeviceBean, int id, String status) {
        this.mContext = mContext;
        this.findDeviceBean = findDeviceBean;
        this.id = id;
        this.status = status;
    }

    @Override
    public int getCount() {
        return findDeviceBean.getData().get(0).getCommonds().size();
    }

    @Override
    public Object getItem(int position) {
        return findDeviceBean.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder;
        if (null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.pop_grid_item, null);
            holder = new Holder();
            holder.button = convertView.findViewById(R.id.pop_grid_btn);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        switch (findDeviceBean.getData().get(0).getCommonds().get(position).getStatus()) {

            case "OPEN":
                if (status.equals("00")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.griditem));
                } else if (status.equals("01")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.gray));
                } else if (status.equals("OPEN")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.gray));
                } else if (status.equals("CLOSE")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.griditem));
                } else if (status.equals("STOP")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.griditem));
                }

                break;

            case "CLOSE":

                if (status.equals("00")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.gray));
                } else if (status.equals("01")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.griditem));
                } else if (status.equals("OPEN")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.gray));
                } else if (status.equals("CLOSE")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.griditem));
                } else if (status.equals("STOP")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.griditem));
                }

                break;

            case "STOP":
                if (status.equals("OPEN")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.griditem));
                } else if (status.equals("CLOSE")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.griditem));
                } else if (status.equals("STOP")) {
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.gray));
                }else if(status.equals("00")){
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.gray));
                }else if(status.equals("01")){
                    holder.button.setTextColor(mContext.getResources().getColor(R.color.gray));
                }


                break;

        }
        holder.button.setText(findDeviceBean.getData().get(0).getCommonds().get(position).getCommondName());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.operateCircuitry(findDeviceBean.getData().get(0).getCommonds().get(position).getStatus(), id);
            }
        });
        return convertView;
    }


    class Holder {
        Button button;
    }
}
