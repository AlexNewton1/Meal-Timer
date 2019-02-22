package com.softwareoverflow.mealtimer.fragments.mealItems;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.fragments.MealWizardFragment;
import com.softwareoverflow.mealtimer.ui.MealViewPager;
import com.softwareoverflow.mealtimer.ui.pagerAdapters.MealItemsControllerPagerAdapter;

public class MealItemControllerFragment extends MealWizardFragment implements View.OnClickListener {

    MealViewPager mealItemControllerPager;
    MealItemsControllerPagerAdapter adapter;

    public MealItemControllerFragment() {
        super(R.drawable.arrow_right, R.drawable.arrow_left);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_item_controller, container, false);

        mealItemControllerPager = view.findViewById(R.id.fragment_meal_items_controller_view_pager);

        adapter = new MealItemsControllerPagerAdapter(getActivity().getSupportFragmentManager());
        mealItemControllerPager.setAdapter(adapter);

        mealFragmentNavigatorActivity.getFAB().setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        mealItemControllerPager.setCurrentItem(mealItemControllerPager.getCurrentItem() + 1);
    }

    @Override
    public void onBackButtonClicked() {
        int currentItem = mealItemControllerPager.getCurrentItem();
        if(currentItem == 0)
            super.onBackButtonClicked();
        else
            mealItemControllerPager.setCurrentItem(mealItemControllerPager.getCurrentItem() - 1);
    }
}
