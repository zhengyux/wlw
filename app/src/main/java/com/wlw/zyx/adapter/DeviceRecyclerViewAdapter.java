package com.wlw.zyx.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.wlw.zyx.activity.MainActivity;
import com.wlw.zyx.R;
import com.wlw.zyx.bean.DeviceBean;
import com.wlw.zyx.util.okhttp.NetWork;


/**
 * 设备列表适配器
 */
public class DeviceRecyclerViewAdapter extends RecyclerView.Adapter<DeviceRecyclerViewAdapter.RecyclerHolder> {

    private MainActivity mContext;
    private DeviceBean deviceBean;

    public DeviceRecyclerViewAdapter(MainActivity context, DeviceBean deviceBean) {
        this.mContext = context;
        this.deviceBean = deviceBean;
    }

    public void refreshData() {
        this.notifyDataSetChanged();

    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerHolder(LayoutInflater.from(mContext).inflate(R.layout.recycler_f_item, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.tv_f_item.setText(deviceBean.getResult().getSortList().get(position).getName());
        if (deviceBean.getResult().getSortList().get(position).getDeviceType() != null && deviceBean.getResult().getSortList().get(position).getDeviceType().length() != 0) {
            holder.aSwitch.setVisibility(View.VISIBLE);
            holder.aSwitch.setOnCheckedChangeListener(null);
            holder.aSwitch.setChecked(deviceBean.getResult().getSortList().get(position).getChecked());

            holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        mContext.closeDevice(NetWork.code, deviceBean.getResult().getSortList().get(position).getDeviceType(), "01");

                    } else {
                        mContext.closeDevice(NetWork.code, deviceBean.getResult().getSortList().get(position).getDeviceType(), "00");

                    }
                }
            });
        }


        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        SRecyclerAdapter sRecyclerAdapter = new SRecyclerAdapter(position);
        holder.recyclerView.setAdapter(sRecyclerAdapter);
        sRecyclerAdapter.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return deviceBean.getResult().getSortList().size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        public TextView tv_f_item;
        RecyclerView recyclerView;
        Switch aSwitch;

        RecyclerHolder(View itemView) {

            super(itemView);
            tv_f_item = itemView.findViewById(R.id.tv_f_item);
            recyclerView = itemView.findViewById(R.id.rec_s);
            aSwitch = itemView.findViewById(R.id.sw_f_item);
        }

    }

    /**
     * 设备适配器
     */
    public class SRecyclerAdapter extends RecyclerView.Adapter<SRecyclerAdapter.SRecyclerHodle> {

        private int fPosition;


        SRecyclerAdapter(int position) {
            this.fPosition = position;
        }

        @NonNull
        @Override
        public SRecyclerAdapter.SRecyclerHodle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new SRecyclerHodle(LayoutInflater.from(mContext).inflate(R.layout.recycler_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull final SRecyclerAdapter.SRecyclerHodle holder, @SuppressLint("RecyclerView") final int position) {

            holder.item_logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.getFindDevice(deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getDeviceType(), holder.item_logo, deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getId(), deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getStatus());

                }
            });

            holder.item_tv.setText(deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getName());

            switch (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getDeviceType()) {

                case "1"://灯光
                    if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getStatus().equals("00")) {
                        holder.item_logo.setImageResource(R.mipmap.icon_d1_more);
                    } else {
                        holder.item_logo.setImageResource(R.mipmap.icon_d1_down);
                    }

                    break;
                case "2"://窗帘
                    if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getBrightness() == 0) {
                        holder.item_logo.setImageResource(R.mipmap.icon_cl3);
                    } else if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getBrightness() == 100) {
                        holder.item_logo.setImageResource(R.mipmap.icon_cl1);
                    } else {
                        holder.item_logo.setImageResource(R.mipmap.icon_cl2);
                    }

                    break;
                case "3"://多媒体
                    if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getStatus().equals("00")) {
                        holder.item_logo.setImageResource(R.mipmap.icon_dmt_more);
                    } else {
                        holder.item_logo.setImageResource(R.mipmap.icon_dmt_down);
                    }

                    break;
                case "4"://空调

                    if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getStatus().equals("00")) {
                        holder.item_logo.setImageResource(R.mipmap.icon_kt1_more);
                    } else {
                        holder.item_logo.setImageResource(R.mipmap.icon_kt1_down);
                    }


                    break;
                case "5"://风扇

                    if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getStatus().equals("00")) {
                        holder.item_logo.setImageResource(R.mipmap.icon_fs1_more);
                    } else {
                        holder.item_logo.setImageResource(R.mipmap.icon_fs1_down);
                    }


                    break;
                case "6"://投影仪

                    if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getStatus().equals("00")) {
                        holder.item_logo.setImageResource(R.mipmap.icon_tyy_more);
                    } else {
                        holder.item_logo.setImageResource(R.mipmap.icon_tyy_down);
                    }

                    break;

                case "7"://班牌

                    if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getStatus().equals("00")) {
                        holder.item_logo.setImageResource(R.mipmap.icon_bp_more);
                    } else {
                        holder.item_logo.setImageResource(R.mipmap.icon_bp_down);
                    }


                    break;
                case "8"://其他
                    if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getStatus().equals("00")) {
                        holder.item_logo.setImageResource(R.mipmap.icon_qt_more);
                    } else {
                        holder.item_logo.setImageResource(R.mipmap.icon_qt_down);
                    }

                    break;

                case "9"://门禁
                    if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getStatus().equals("00")) {
                        holder.item_logo.setImageResource(R.mipmap.icon_mj1_more);
                    } else {
                        holder.item_logo.setImageResource(R.mipmap.icon_mj1_down);
                    }

                    break;
                case "10"://一体机
                    if (deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().get(position).getStatus().equals("00")) {
                        holder.item_logo.setImageResource(R.mipmap.icon_ytj_more);
                    } else {
                        holder.item_logo.setImageResource(R.mipmap.icon_ytj_down);
                    }

                    break;
            }


        }

        @Override
        public int getItemCount() {
            return deviceBean.getResult().getSortList().get(fPosition).getCircuitryList().size();
        }

        public class SRecyclerHodle extends RecyclerView.ViewHolder {

            public TextView item_tv;
            public ImageView item_logo;
            public Button item_switch;

            SRecyclerHodle(View itemView) {
                super(itemView);
                item_tv = itemView.findViewById(R.id.item_tv);
                item_logo = itemView.findViewById(R.id.item_logo);
                item_switch = itemView.findViewById(R.id.item_switch);
            }
        }
    }


}