package com.softwareoverflow.mealtimer.fragments.mealItems;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwareoverflow.mealtimer.FragmentCancellable;
import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.fragments.MealWizardFragment;
import com.softwareoverflow.mealtimer.ui.MealViewPager;
import com.softwareoverflow.mealtimer.ui.pagerAdapters.MealItemsControllerPagerAdapter;

public class MealItemControllerFragment extends MealWizardFragment implements View.OnClickListener {

    MealViewPager mealItemControllerPager;
    MealItemsControllerPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_item_controller, container, false);

        mealItemControllerPager = view.findViewById(R.id.fragment_meal_items_controller_view_pager);

        adapter = new MealItemsControllerPagerAdapter(getActivity().getSupportFragmentManager());
        mealItemControllerPager.setAdapter(adapter);

        mealWizardActivity.getFAB().setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        mealItemControllerPager.setCurrentItem(mealItemControllerPager.getCurrentItem() + 1);
    }

    public void onBackButtonClicked() {
        int currentItem = mealItemControllerPager.getCurrentItem();

        MealWizardFragment fragment = adapter.getFragment(currentItem);
        if(fragment instanceof FragmentCancellable)
            ((FragmentCancellable) fragment).onNegativeButtonClicked(mealItemControllerPager);
        else if(currentItem == 0)
            mealWizardActivity.previousWizardStep();
        else
            mealItemControllerPager.setCurrentItem(currentItem - 1);
    }

    public void onNextButtonClicked() {
        int currentItem = mealItemControllerPager.getCurrentItem();

        MealWizardFragment fragment = adapter.getFragment(currentItem);
        if(fragment instanceof FragmentCancellable)
            ((FragmentCancellable) fragment).onPositiveButtonClicked(mealItemControllerPager);
        else if (currentItem == 0)
            mealWizardActivity.nextWizardStep();
        else
            mealItemControllerPager.setCurrentItem(currentItem + 1);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }
}
