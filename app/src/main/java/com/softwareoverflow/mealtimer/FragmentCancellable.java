package com.softwareoverflow.mealtimer;

import android.support.v4.view.ViewPager;

public interface FragmentCancellable {

    void onNegativeButtonClicked(ViewPager viewPager);

    void onPositiveButtonClicked(ViewPager viewPager);
}
