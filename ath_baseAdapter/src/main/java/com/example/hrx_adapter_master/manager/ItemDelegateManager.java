package com.example.hrx_adapter_master.manager;



import android.support.v4.util.SparseArrayCompat;
import android.util.SparseArray;

import com.example.hrx_adapter_master.delegate.base.IitemDelegate;
import com.example.hrx_adapter_master.holder.AutoViewHolder;
import com.example.hrx_adapter_master.manager.base.IDelegateManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * Created by houruixiang on 2018/4/16.
 */

public class ItemDelegateManager<T> implements IDelegateManager<T>{


    SparseArrayCompat<IitemDelegate<T>> spArr = new SparseArrayCompat<>();


    //model
    @Override
    public IDelegateManager<T> addDelegate(IitemDelegate<T> item) {
        int viewType = spArr.size() - 1;
        if (spArr.get(viewType) == null && item != null){
            spArr.put(viewType,item);
            viewType++;
        }else {
            putThrow("this delegate is already create or  params is null ");
        }

        return this;
    }

    @Override
    public IDelegateManager<T> addDelegate(int ViewType, IitemDelegate<T> item) {
        if (spArr.get(ViewType) == null && item != null){
            spArr.put(ViewType,item);
        }else {
            putThrow("this delegate is already create or  params is null ");
        }
        return this;
    }


    @Override
    public IDelegateManager<T> addAllDelegate(SparseArrayCompat<IitemDelegate<T>> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            if (spArr.get(itemList.keyAt(i)) != null || itemList.valueAt(i) == null){
                putThrow("this delegate is already create or  params is null ");
            }else {
                spArr.put(itemList.keyAt(i),itemList.valueAt(i));
            }

        }
        return this;
    }

    @Override
    public IDelegateManager<T> addAllDelegate(SparseArray<IitemDelegate<T>> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            if (spArr.get(itemList.keyAt(i)) != null || itemList.valueAt(i) == null){
                putThrow("this delegate is already create or  params is null ");
            }else {
                spArr.put(itemList.keyAt(i),itemList.valueAt(i));
            }

        }
        return this;
    }

    @Override
    public IDelegateManager<T> addAllDelegate(List<IitemDelegate<T>> itemList) {
        int viewType = spArr.size() - 1;
        for (int i = 0; i < itemList.size(); i++) {
            if (spArr.get(viewType) != null || itemList.get(i) == null){
                putThrow("this delegate is already create or  params is null ");
            }else {
                spArr.put(viewType,itemList.get(i));
            }

        }
        return this;
    }

    @Override
    public IDelegateManager<T> addAllDelegate(IitemDelegate<T>[] itemList) {
        int viewType = spArr.size() - 1;
        for (int i = 0; i < itemList.length - 1; i++) {
            if (spArr.get(viewType) != null || itemList[i] == null){
                putThrow("this delegate is already create or  params is null ");
            }else {
                spArr.put(viewType,itemList[i]);
            }

        }
        return this;
    }

    @Override
    public IDelegateManager<T> addAllDelegate(HashMap<Integer, IitemDelegate<T>> itemList) {
        Set<Integer> integers = itemList.keySet();
        Iterator<Integer> iterator = integers.iterator();
        if (iterator.hasNext()){
            int key = iterator.next();
            IitemDelegate<T> tIitemDelegate = itemList.get(key);
            spArr.put(key,tIitemDelegate);
        }

        return this;
    }

    @Override
    public IDelegateManager<T> removeDelegate(int ViewType) {
        spArr.remove(ViewType);
        return this;
    }


    /**
     *holder bind  data
     * @param holder
     * @param itemBean
     * @param position
     */
    @Override
    public void convert(AutoViewHolder holder, T itemBean, int position) {
        for (int i = 0; i < spArr.size(); i++) {
            IitemDelegate<T> tIitemDelegate = spArr.valueAt(i);
            if (tIitemDelegate.isViewType(itemBean,position)){

                tIitemDelegate.convert(holder,itemBean,position);
            }
        }
    }


    @Override
    public IitemDelegate<T> getItemViewDelegate(int viewType)
    {
        return spArr.get(viewType);
    }

    @Override
    public int getItemViewLayoutId(int viewType)
    {
        return getItemViewDelegate(viewType).getItemLayoutId();
    }

    @Override
    public int getItemViewType(IitemDelegate<T> itemViewDelegate)
    {
        return spArr.keyAt(spArr.indexOfValue(itemViewDelegate));
    }


    @Override
    public int getItemViewType(T itemBean,int position)
    {
        for (int i = 0; i < spArr.size(); i++) {
            IitemDelegate<T> tIitemDelegate = spArr.valueAt(i);
            if (tIitemDelegate.isViewType(itemBean,position)){
                return spArr.keyAt(i);
            }
        }
        return 0;
    }




    public void putThrow(String err){
        throw new IllegalArgumentException(err);
    }

    public int getCount() {

        return spArr.size();
    }
}
