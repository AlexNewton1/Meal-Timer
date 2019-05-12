package com.softwareoverflow.mealtimer.ui.pagerAdapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.softwareoverflow.mealtimer.fragments.mealReadyTime.MealReadyDatePickerFragment;
import com.softwareoverflow.mealtimer.fragments.mealReadyTime.MealReadyTimePickerFragment;

public class MealReadyDateTimePagerAdapter extends FragmentPagerAdapter {

    private SparseArray<Fragment> fragments = new SparseArray<>();
    private DatePicker.OnDateChangedListener dateChangedListener;
    private TimePicker.OnTimeChangedListener timeChangedListener;

    public MealReadyDateTimePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                MealReadyDatePickerFragment dateFragment = new MealReadyDatePickerFragment();
                //dateFragment.setOnDateChangedListener(dateChangedListener);
                return dateFragment;
            case 1:
                MealReadyTimePickerFragment timeFragment =  new MealReadyTimePickerFragment();
                timeFragment.setOnTimeChangedListener(timeChangedListener);
                return timeFragment;
            default: return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) return "Date";
        else if (position == 1) return "Time";
        else throw new UnsupportedOperationException("Fragment position not supported: " + position);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
        fragments.put(position, createdFragment);

        return createdFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    public void setDateChangedListener(DatePicker.OnDateChangedListener listener){
        dateChangedListener = listener;
    }

    public void setTimeChangedListener(TimePicker.OnTimeChangedListener listener){
        timeChangedListener = listener;
    }

    public void switchTab(View v) {

    }
}
