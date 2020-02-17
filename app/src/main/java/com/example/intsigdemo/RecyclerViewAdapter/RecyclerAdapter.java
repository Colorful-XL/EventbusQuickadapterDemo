package com.example.intsigdemo.RecyclerViewAdapter;

import android.content.Intent;
import android.transition.Visibility;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.intsigdemo.Bean.RecyclerChildData;
import com.example.intsigdemo.Bean.RecyclerData;
import com.example.intsigdemo.R;

import java.util.List;

public class RecyclerAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity , BaseViewHolder> {
    public static final int TYPE_ONE = 0;
    public static final  int TYPE_TOW = 1;

    public RecyclerAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_ONE , R.layout.item_recycler);
        addItemType(TYPE_TOW , R.layout.item_recycle_2th);
    }


    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        this.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (((RecyclerData)adapter.getItem(position)).isExpanded()){
                    collapse(position);
                }else {
                    expand(position);
                }
            }
        });
        switch (helper.getItemViewType()){
            case TYPE_ONE:{
                RecyclerData data = (RecyclerData) item;
                helper.setText(R.id.recycler_item_text , data.getContent());
                helper.addOnClickListener(R.id.btnRecycler);
                helper.setText(R.id.btnRecycler,"展开");
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext ,data.getTargetClass());
                        mContext.startActivity(intent);
                    }
                });
                if (!data.hasSubItem()){
                    helper.setVisible(R.id.btnRecycler , false);
                }
                break;
            }

            case TYPE_TOW:{
                RecyclerChildData data = (RecyclerChildData)item;
                helper.setText(R.id.recycler_item_2th_text , ((RecyclerChildData) item).getContent());
                helper.itemView.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext ,data.getTargetClass());
                        mContext.startActivity(intent);
                    }
                });
                break;
            }
        }
    }


}
