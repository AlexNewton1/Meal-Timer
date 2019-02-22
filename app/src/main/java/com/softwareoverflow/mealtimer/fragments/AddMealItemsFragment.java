package com.softwareoverflow.mealtimer.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.meal.MealItem;
import com.softwareoverflow.mealtimer.ui.listAdapters.MealItemListAdapter;

import java.util.List;

/**
 * This fragment is responsible for handling the adding of
 * {@link com.softwareoverflow.mealtimer.meal.MealItem} objects which create the meal
 */
public class AddMealItemsFragment extends MealWizardFragment implements View.OnClickListener{

    private List<MealItem> mealItems;

    public AddMealItemsFragment() {
        super(R.drawable.arrow_right_faded, R.drawable.arrow_left);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_meal_items, container, false);

        mealFragmentNavigatorActivity.getFAB().setOnClickListener(this);

        mealItems = mealFragmentNavigatorActivity.getMeal().getMealItems();

        MealItemListAdapter adapter = new MealItemListAdapter(mealItems);

        RecyclerView mealItemsRV = view.findViewById(R.id.fragment_meal_items_recycler_view);
        mealItemsRV.addItemDecoration(new DividerItemDecoration(mealItemsRV.getContext(),
                DividerItemDecoration.VERTICAL));

        mealItemsRV.setAdapter(adapter);
        mealItemsRV.setLayoutManager(new LinearLayoutManager(getContext()));
        mealItemsRV.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        return view;
    }

    @Override
    public void onClick(View v) {
        FragmentActivity activity = (FragmentActivity) mealFragmentNavigatorActivity;

        switch (activity.getSupportFragmentManager().getBackStackEntryCount()){
            case 0: // Add meal Items screen
                SavedMealItemsFragment savedMealItemsFragment = new SavedMealItemsFragment();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(((ViewGroup) getView().getParent()).getId(),
                                savedMealItemsFragment, savedMealItemsFragment.getClass().toString())
                        .addToBackStack(savedMealItemsFragment.getClass().toString())
                        .commit();

                break;
            case 1: // SavedMealItemsScreen TODO - use startActivtyForResult at this point?


                break;


            case 2: //Create New Meal Item Screen TODO - use startActivityForResult approach?


                break;
        }




    }
}
