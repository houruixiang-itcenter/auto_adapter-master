package m.com.example.auto_adapter_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.hrx_adapter_master.manager.ItemDelegateManager;

import java.util.ArrayList;

import m.com.example.auto_adapter_master.adapter.MyAdapter;
import m.com.example.auto_adapter_master.delegate.SimpleItemDelegate;

public class MainActivity extends AppCompatActivity {

    /**
     * 注意 在本demo中知识简单实现adapter wheel的功能 即适配器的封装
     * 功能的简单使用 ui部分 没有严格的封装
     *
     *
     * ----后序 还需要有动画 的实现 分割线的自定义等等 2018/3/5
     */

    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private ArrayList<String> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        //initToolbar();

        initData();

        initEvent();
    }



    private void initView() {
        mRecyclerView = findViewById(R.id.recycler);

    }




    private void initData() {
        info = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            info.add("recycler-item" + i);
        }
    }


    private void initEvent() {
        MyAdapter adapter = new MyAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);

        new ItemDelegateManager<>();

        adapter.setData(info);
        adapter.addDelegate(new SimpleItemDelegate(this,R.layout.item_main));
        adapter.notifyDataSetChanged();
    }
}
