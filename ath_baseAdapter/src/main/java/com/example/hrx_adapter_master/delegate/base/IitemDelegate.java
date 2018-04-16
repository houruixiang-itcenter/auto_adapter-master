package com.example.hrx_adapter_master.delegate.base;

import com.example.hrx_adapter_master.holder.AutoViewHolder;

/**
 * Created by houruixiang on 2018/4/16.
 */

public interface IitemDelegate<T> {

    boolean isViewType(T itemBean);

    boolean isViewType(T itemBean,int position);

    int getItemLayoutId();



    void convert(AutoViewHolder holder,T itemBean,int position);


}
