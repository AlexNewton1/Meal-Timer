package com.softwareoverflow.mealtimer.fragments.mealItems;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.fragments.MealWizardFragment;
import com.softwareoverflow.mealtimer.meal.MealItem;
import com.softwareoverflow.mealtimer.ui.listAdapters.MealItemListAdapter;

import java.util.List;

/**
 * This fragment is responsible for handling the adding of
 * {@link com.softwareoverflow.mealtimer.meal.MealItem} objects which create the meal
 */
public class AddMealItemsFragment extends MealWizardFragment {

    private MealItemListAdapter listAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_meal_items, container, false);

        List<MealItem>  mealItems = mealWizardNavigatorActivity.getMeal().getMealItems();
        listAdapter = new MealItemListAdapter(mealItems);

        RecyclerView mealItemsRV = view.findViewById(R.id.fragment_meal_items_recycler_view);
        mealItemsRV.addItemDecoration(new DividerItemDecoration(mealItemsRV.getContext(),
                DividerItemDecoration.VERTICAL));

        mealItemsRV.setAdapter(listAdapter);
        mealItemsRV.setLayoutManager(new LinearLayoutManager(getContext()));
        mealItemsRV.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser && listAdapter != null)
            listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();

        if(getUserVisibleHint())
            listAdapter.notifyDataSetChanged();
    }
}
