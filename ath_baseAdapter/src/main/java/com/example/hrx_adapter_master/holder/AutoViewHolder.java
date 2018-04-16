package com.example.hrx_adapter_master.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hrx_adapter_master.holder.base.BaseHolder;

/**
 * Created by houruixiang on 2018/3/5.
 */

public class AutoViewHolder extends BaseHolder{


    private View itemView;
    private Context mContext;

    public AutoViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public void setContext(Context mContext) {
        this.mContext = mContext;
    }


    public View getRootView(){
        return itemView;
    };


    public <T extends View>T getView(int resId){
        View tarView = itemView.findViewById(resId);
        return (T)tarView;
    }


    /**
     * 设置text -- content
     * @param viewId
     * @param text
     * @return
     */
    public AutoViewHolder setText(int viewId, String text)
    {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 设置text 颜色 --- <int><color/>
     * @param viewId
     * @param textColor
     * @return
     */
    public AutoViewHolder setTextColor(int viewId, int textColor)
    {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    /**
     * 设置字体大小 --- size
     * @param viewId
     * @param size
     * @return
     */
    public AutoViewHolder setTextSize(int viewId, int size)
    {
        TextView view = getView(viewId);
        view.setTextSize(size);
        return this;
    }



    /**-------------------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * 设置图片 --- resId
     * @param viewId
     * @param resId
     * @return
     */
    public AutoViewHolder setImageResource(int viewId, int resId)
    {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }


    /**
     * 设置图片 --- bitmap
     * @param viewId
     * @param bitmap
     * @return
     */
    public AutoViewHolder setImageBitmap(int viewId, Bitmap bitmap)
    {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 设置图片 --- drawable
     * @param viewId
     * @param drawable
     * @return
     */
    public AutoViewHolder setImageDrawable(int viewId, Drawable drawable)
    {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    /**
     * 设置背景颜色 -- <int><color/>
     * @param viewId
     * @param color
     * @return
     */
    public AutoViewHolder setBackgroundColor(int viewId, int color)
    {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }






}
