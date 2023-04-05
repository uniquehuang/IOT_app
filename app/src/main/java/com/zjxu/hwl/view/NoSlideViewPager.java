package com.zjxu.hwl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class NoSlideViewPager extends ViewPager{
    public NoSlideViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet){
        super(context,attributeSet);
    }
    private boolean isSlidable = false;
    @Override
    public boolean onTouchEvent(MotionEvent event){
        return this.isSlidable&&super.onTouchEvent(event);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event){
        return this.isSlidable&&super.onInterceptTouchEvent(event);
    }
    public void setSlidable(boolean slidable){
        isSlidable=slidable;
    }

}
