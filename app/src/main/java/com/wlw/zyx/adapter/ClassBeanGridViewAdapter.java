package com.wlw.zyx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wlw.zyx.R;
import com.wlw.zyx.bean.ClassBean;


public class ClassBeanGridViewAdapter extends BaseAdapter{

    private Context mContext;
    private ClassBean classBean;

    public ClassBeanGridViewAdapter(Context mContext, ClassBean classBean) {
        this.mContext = mContext;
        this.classBean = classBean;
    }



    @Override
    public int getCount() {
        return classBean.getResult().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return classBean.getResult().getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if(null == convertView){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gridview_item,null);
            holder = new Holder();
            holder.textView = convertView.findViewById(R.id.griditem_tv);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
            holder.textView.setText(classBean.getResult().getData().get(position).getPurposeName());



        return convertView;
    }

    class Holder{
        TextView textView;
    }

}
