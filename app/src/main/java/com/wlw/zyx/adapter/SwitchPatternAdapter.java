package com.wlw.zyx.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wlw.zyx.R;
import com.wlw.zyx.activity.MainActivity;
import com.wlw.zyx.bean.DeviceBean;

/**
 * 项目名称：WLW
 * 类描述：
 * 创建人：xuan
 * 创建时间：2018/8/2 16:12
 * 修改人：xuan
 * 修改时间：2018/8/2 16:12
 * 修改备注：
 */
public class SwitchPatternAdapter extends RecyclerView.Adapter<SwitchPatternAdapter.SwitchPatternHolder>{

    private MainActivity mContext;
    private DeviceBean deviceBean;

    public SwitchPatternAdapter(MainActivity mContext, DeviceBean deviceBean) {
        this.mContext = mContext;
        this.deviceBean = deviceBean;
    }

    @NonNull
    @Override
    public SwitchPatternHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SwitchPatternHolder holder = new SwitchPatternHolder(LayoutInflater.from(mContext).inflate(R.layout.recycler_item_switchpattern, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SwitchPatternHolder holder, final int position) {

        if(deviceBean.getResult().getSwitchPatternList().get(position).getStatus().equals("01")){
            holder.textView.setTextColor(mContext.getResources().getColor(R.color.griditem));
            switch (deviceBean.getResult().getSwitchPatternList().get(position).getId()){
                case 24:
                    holder.imageView.setImageResource(R.drawable.icon_bs_down);
                    break;
                case 27:
                    holder.imageView.setImageResource(R.drawable.icon_yd_down);
                    break;
                case 30:
                    holder.imageView.setImageResource(R.drawable.icon_ppt_down);
                    break;
            }

        }else {
            holder.textView.setTextColor(mContext.getResources().getColor(R.color.darkgray));
            switch (deviceBean.getResult().getSwitchPatternList().get(position).getId()){
                case 24:
                    holder.imageView.setImageResource(R.drawable.icon_bs_more);
                    break;
                case 27:
                    holder.imageView.setImageResource(R.drawable.icon_yd_more);
                    break;
                case 30:
                    holder.imageView.setImageResource(R.drawable.icon_ppt_more);
                    break;
            }



        }
        holder.textView.setText(deviceBean.getResult().getSwitchPatternList().get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.operateSwitchPattern(String.valueOf(deviceBean.getResult().getSwitchPatternList().get(position).getId()));
            }
        });


    }

    @Override
    public int getItemCount() {
        return deviceBean.getResult().getSwitchPatternList().size();
    }

    public class SwitchPatternHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imageView;

       public SwitchPatternHolder(View itemView) {
           super(itemView);
           textView = itemView.findViewById(R.id.recycler_item_switchpattern_tv);
           imageView = itemView.findViewById(R.id.recycler_item_switchpattern_im);
       }
   }


}
