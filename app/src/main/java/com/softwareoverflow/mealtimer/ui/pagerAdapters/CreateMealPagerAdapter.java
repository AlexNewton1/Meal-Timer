package com.softwareoverflow.mealtimer.ui.pagerAdapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.softwareoverflow.mealtimer.fragments.MealReadyTimeFragment;
import com.softwareoverflow.mealtimer.fragments.MealWizardFragment;
import com.softwareoverflow.mealtimer.fragments.mealItems.MealItemControllerFragment;

public class CreateMealPagerAdapter extends FragmentPagerAdapter {

   private SparseArray<MealWizardFragment> mealWizardFragments = new SparseArray<>();

    public CreateMealPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0: return new MealItemControllerFragment();
            case 1: return new MealReadyTimeFragment();
            default: return null;
        }
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        MealWizardFragment createdFragment = (MealWizardFragment) super.instantiateItem(container, position);
        mealWizardFragments.put(position, createdFragment);

        return createdFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    public MealWizardFragment getFragment(int position) {
        return mealWizardFragments.get(position);
    }
}
