package com.example.intsigdemo.Bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.intsigdemo.RecyclerViewAdapter.RecyclerAdapter;

public class RecyclerChildData implements MultiItemEntity {
    private String content;
    private Class targetClass;

    public RecyclerChildData(String content, Class targetClass) {
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
    public int getItemType() {
        return RecyclerAdapter.TYPE_TOW;
    }
}
