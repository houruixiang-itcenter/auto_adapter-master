package com.example.hrx_adapter_master.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hrx_adapter_master.delegate.base.IitemDelegate;
import com.example.hrx_adapter_master.holder.AutoViewHolder;
import com.example.hrx_adapter_master.manager.ItemDelegateManager;

import java.util.List;

/**
 * Created by houruixiang on 2018/3/5.
 */

public abstract class BaseAutoAdapter<T> extends RecyclerView.Adapter<AutoViewHolder> {

    public Context mContext;
    public List<T> mData;
    private final LayoutInflater inflater;
    private ItemDelegateManager<T> mItemDelegateManager;

    public BaseAutoAdapter(Context context) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<T> data){
        this.mData = data;
        //初始化
        mItemDelegateManager = new ItemDelegateManager<>();
    }


    /**
     * 在这里 view的绑定 由base基类自己来实现
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public AutoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int itemViewLayoutId = mItemDelegateManager.getItemViewLayoutId(viewType);
        AutoViewHolder holder = new AutoViewHolder(inflater.inflate(itemViewLayoutId,parent,false));
        holder.setContext(mContext);

        initClick(holder,parent,viewType);
        return holder;
    }

    private void initClick(final AutoViewHolder holder, ViewGroup parent, int viewType) {
        holder.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                listener.clickEvent(v,position,holder);
            }
        });
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (isUseDelegate()){
            return mItemDelegateManager.getItemViewType(mData.get(position),position);
        }
        return super.getItemViewType(position);
    }

    public boolean isUseDelegate(){
        return  mItemDelegateManager.getCount() > 0;
    }

    @Override
    public void onBindViewHolder(AutoViewHolder holder, int position) {
        //use delegate  y/n?
            convert(holder,mData.get(position));

    }

    /**
     * holder与网络的交互  泛型在子类指定  然后进行定制化的实现
     * @param holder
     * @param t
     */
    protected void convert(AutoViewHolder holder, T t){
        //simple adapter  logic
        mItemDelegateManager.convert(holder,t,holder.getAdapterPosition());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    };


    /**---------------------------------------------------------------------------------------------------------------------------------------*/

    public OnItemClickListener listener;

    /**
     * 在RecyclerView中没有暴露点击item的点击API  这里自己实现
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


    public interface OnItemClickListener{
        void clickEvent(View v ,int position,AutoViewHolder holder);
    }


    public void addDelegate(IitemDelegate<T> delegate){
        mItemDelegateManager.addDelegate(delegate);
    }


    public void addDelegate(int ViewType,IitemDelegate<T> delegate){
        mItemDelegateManager.addDelegate(ViewType,delegate);
    }


}
