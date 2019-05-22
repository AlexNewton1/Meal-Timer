package com.softwareoverflow.mealtimer.ui.pagerAdapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.softwareoverflow.mealtimer.fragments.mealItems.AddMealItemsFragment;
import com.softwareoverflow.mealtimer.fragments.mealItems.EditMealItemFragment;
import com.softwareoverflow.mealtimer.fragments.MealWizardFragment;
import com.softwareoverflow.mealtimer.fragments.mealItems.SavedMealItemsFragment;

public class MealItemsControllerPagerAdapter extends FragmentPagerAdapter {

    private SparseArray<MealWizardFragment> mealItemFragments = new SparseArray<>();

    public MealItemsControllerPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0: return new AddMealItemsFragment();
            case 1: return new SavedMealItemsFragment();
            case 2: return new EditMealItemFragment();
            //TODO - case x: return new CreateMealItemStageFragment();??
            default: return null;
        }
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        MealWizardFragment createdFragment = (MealWizardFragment) super.instantiateItem(container, position);
        mealItemFragments.put(position, createdFragment);

        return createdFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public MealWizardFragment getFragment(int position) {
        return mealItemFragments.get(position);
    }
}
