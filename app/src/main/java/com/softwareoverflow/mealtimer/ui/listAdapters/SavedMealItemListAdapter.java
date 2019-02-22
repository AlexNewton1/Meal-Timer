package com.softwareoverflow.mealtimer.ui.listAdapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.meal.MealItem;

import java.util.List;

public class SavedMealItemListAdapter extends MealItemListAdapter {

    public SavedMealItemListAdapter(List<MealItem> mealItems) {
        super(mealItems);
    }

    @NonNull
    @Override
    public MealItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_saved_meal_items, parent, false);
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
