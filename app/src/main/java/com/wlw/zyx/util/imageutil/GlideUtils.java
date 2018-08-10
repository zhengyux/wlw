package com.wlw.zyx.util.imageutil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.wlw.zyx.R;



/**
 * 项目名称：WLW
 * 类描述：图片加载4.7.1版本
 * 创建人：xuan
 * 创建时间：2018/8/10 14:12
 * 修改人：xuan
 * 修改时间：2018/8/10 14:12
 * 修改备注：
 */
public class GlideUtils {

    public static final int placeholderImage = R.mipmap.ic_launcher;
    public static final int errorImage = R.mipmap.ic_launcher;


    /**
     * 普通加载
     * @param context
     * @param url
     * @param imageView
     */
    public static void LoadImage(Context context, String url, ImageView imageView){

        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().placeholder(placeholderImage).error(errorImage))
                .into(imageView);
    }

    /**
     * 加载圆形图标
     * @param context
     * @param url
     * @param imageView
     */
    public static void LoadCircleImage(Context context, String url, ImageView imageView){

        Glide.with(context)
                .load(url)
                .apply(new RequestOptions().placeholder(placeholderImage).error(errorImage).centerCrop().transform(new GlideCircleTransform()))
                .into(imageView);
    }


}
