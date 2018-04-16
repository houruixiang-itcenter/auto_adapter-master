package com.example.hrx_adapter_master.manager.base;

import android.support.v4.util.SparseArrayCompat;
import android.util.SparseArray;

import com.example.hrx_adapter_master.delegate.base.IitemDelegate;
import com.example.hrx_adapter_master.holder.AutoViewHolder;

import java.util.HashMap;
import java.util.List;

/**
 * Created by houruixiang on 2018/4/16.
 */

public interface IDelegateManager<T> {

    IDelegateManager<T> addDelegate(IitemDelegate<T> item);

    IDelegateManager<T> addDelegate(int ViewType , IitemDelegate<T> item);



    //建议使用的数据结构
    IDelegateManager<T> addAllDelegate(SparseArrayCompat<IitemDelegate<T>> itemList);

    IDelegateManager<T> addAllDelegate(SparseArray<IitemDelegate<T>> itemList);

    IDelegateManager<T> addAllDelegate(List<IitemDelegate<T>> itemList);

    IDelegateManager<T> addAllDelegate(IitemDelegate<T>[] itemList);

    IDelegateManager<T> addAllDelegate(HashMap<Integer,IitemDelegate<T>> itemList);


    IDelegateManager<T> removeDelegate(int ViewType);


    IitemDelegate<T> getItemViewDelegate(int viewType);

    int getItemViewLayoutId(int viewType);

    int getItemViewType(IitemDelegate<T> itemViewDelegate);


    int getItemViewType(T itemBean,int position);



    void convert(AutoViewHolder holder,T itemBean,int position);





}
