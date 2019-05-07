package com.softwareoverflow.mealtimer.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MealViewPager extends ViewPager {


    public MealViewPager(@NonNull Context context) {
        super(context);
    }

    public MealViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // Don't allow swiping on the viewPager to change views
        return false;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Don't allow swiping on the viewPager to change views
        return false;
    }
}
