package com.example.intsigdemo.Avtivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.intsigdemo.Bean.RecyclerChildData;
import com.example.intsigdemo.Bean.RecyclerData;
import com.example.intsigdemo.R;
import com.example.intsigdemo.RecyclerViewAdapter.RecyclerAdapter;

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
        data2.addSubItem(data3);

        list.add(data1);
        list.add(data2);

        adapter.setNewData(list);
        adapter.notifyDataSetChanged();
    }
}
