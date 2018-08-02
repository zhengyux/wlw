package com.wlw.zyx.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;


import com.wlw.zyx.activity.MainActivity;
import com.wlw.zyx.R;
import com.wlw.zyx.bean.FindDevice;

public class MyPopGridAdapter extends BaseAdapter {

    private MainActivity mContext;
    private FindDevice findDevice;
    private int id;

    public MyPopGridAdapter(MainActivity mContext, FindDevice findDevice,int id) {
        this.mContext = mContext;
        this.findDevice = findDevice;
        this.id=id;
    }

    @Override
    public int getCount() {
        return findDevice.getData().get(0).getCommonds().size();
    }

    @Override
    public Object getItem(int position) {
        return findDevice.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder;
        if(null == convertView){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.pop_grid_item,null);
            holder = new Holder();
            holder.button = convertView.findViewById(R.id.pop_grid_btn);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.button.setText(findDevice.getData().get(0).getCommonds().get(position).getCommondName());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.operateCircuitry(findDevice.getData().get(0).getCommonds().get(position).getStatus(),id);
            }
        });
        return convertView;
    }


    class Holder{
        Button button;
    }
}
