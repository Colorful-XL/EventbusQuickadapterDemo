package com.example.intsigdemo.Bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.intsigdemo.RecyclerViewAdapter.RecyclerAdapter;

public class RecyclerData extends AbstractExpandableItem<RecyclerChildData>
        implements MultiItemEntity {

    private String content;
    private Class targetClass;

    public RecyclerData(String content, Class targetClass) {
        this.content = content;
        this.targetClass = targetClass;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class targetClass) {
        this.targetClass = targetClass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return RecyclerAdapter.TYPE_ONE;
    }
}
