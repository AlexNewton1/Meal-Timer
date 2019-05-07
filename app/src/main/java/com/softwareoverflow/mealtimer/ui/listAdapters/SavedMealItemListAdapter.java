package com.softwareoverflow.mealtimer.ui.listAdapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.meal.Meal;
import com.softwareoverflow.mealtimer.meal.MealItem;

import java.util.List;

public class SavedMealItemListAdapter extends MealItemListAdapter {

    private List<MealItem> mealItems;
    private Meal meal;

    public SavedMealItemListAdapter(List<MealItem> mealItems, Meal meal) {
        super(mealItems);
        this.mealItems = mealItems;
        this.meal = meal;
    }


    @Override
    public int getItemViewType(int position) {
        MealItem mealItem = mealItems.get(position);

        List<MealItem> itemsInMeal = meal.getMealItems();

        if(itemsInMeal.contains(mealItem))
            return 1;
        else return 0;
    }

    @NonNull
    @Override
    public MealItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_saved_meal_items, parent, false);

        AppCompatImageView tickIcon =
                v.findViewById(R.id.list_view_saved_meal_tick);
        tickIcon.setAlpha(Float.valueOf(viewType));

        return new SavedMealItemsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MealItemsViewHolder viewHolder, int position) {
        super.onBindViewHolder(viewHolder, position);
    }

    class SavedMealItemsViewHolder extends MealItemListAdapter.MealItemsViewHolder {
        ImageView tickIcon;

        SavedMealItemsViewHolder(final View itemView){
            super(itemView);
            tickIcon = itemView.findViewById(R.id.list_view_saved_meal_tick);
        }
    }
}
