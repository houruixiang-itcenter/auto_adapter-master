package m.com.example.auto_adapter_master.delegate;


import android.content.Context;

import com.example.hrx_adapter_master.delegate.base.IitemDelegate;
import com.example.hrx_adapter_master.holder.AutoViewHolder;

import m.com.example.auto_adapter_master.R;


/**
 * Created by houruixiang on 2018/4/16.
 */

public class SimpleItemDelegate implements IitemDelegate<String> {


    private int resId;
    private Context context;

    public SimpleItemDelegate(Context context, int resId) {
        this.context = context;
        this.resId = resId;
    }

    @Override
    public boolean isViewType(String itemBean) {
        if (itemBean instanceof String){
            return true;
        }
        return false;
    }

    @Override
    public boolean isViewType(String itemBean, int position) {
        if (itemBean instanceof String){
            return true;
        }
        return false;
    }

    @Override
    public int getItemLayoutId() {
        return resId;
    }


    @Override
    public void convert(AutoViewHolder holder, String itemBean, int position) {
        holder.setText(R.id.txt, (String) itemBean);
    }
}
