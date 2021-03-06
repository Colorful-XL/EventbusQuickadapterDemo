package com.example.EventbusQuickadapterDemo.Avtivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.EventbusQuickadapterDemo.Bean.RecyclerChildData;
import com.example.EventbusQuickadapterDemo.Bean.RecyclerData;
import com.example.EventbusQuickadapterDemo.R;
import com.example.EventbusQuickadapterDemo.RecyclerViewAdapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BaseQuickAdapterActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_quick_adapter);
        init();
    }

    private void init(){
        recyclerView = this.findViewById(R.id.recycler_view);
        adapter = new RecyclerAdapter(new ArrayList<MultiItemEntity>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        initData();
    }

    private void initData(){
        List<MultiItemEntity> list = new ArrayList<>();
        RecyclerData data1 = new RecyclerData("约束布局" , ConstraintLayoutActivity.class);
        RecyclerData data2 = new RecyclerData("EventBus订阅" , EventBusSubActivity.class);
        RecyclerChildData data3 = new RecyclerChildData("EventBus发布" , EventBusPubActivity.class);
        RecyclerData data4 = new RecyclerData("动态权限获取",PermissionActivity.class);
        data2.addSubItem(data3);

        list.add(data1);
        list.add(data2);
        list.add(data4);

        adapter.setNewData(list);
    }
}
