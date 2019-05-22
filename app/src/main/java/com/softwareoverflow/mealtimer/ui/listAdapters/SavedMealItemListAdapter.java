package com.softwareoverflow.mealtimer.ui.listAdapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.softwareoverflow.mealtimer.DeleteRestoreListAdapterListener;
import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.meal.Meal;
import com.softwareoverflow.mealtimer.meal.MealItem;

import java.util.List;

public class SavedMealItemListAdapter extends MealItemListAdapter {

    private List<MealItem> mealItems;
    private Meal meal;

    public SavedMealItemListAdapter(Activity activity, List<MealItem> mealItems, Meal meal, DeleteRestoreListAdapterListener listener) {
        super(activity, mealItems, listener);
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
    public MealItemListAdapter.MealItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_saved_meal_items, parent, false);

        AppCompatImageView tickIcon =
                v.findViewById(R.id.list_view_saved_meal_tick);
        tickIcon.setAlpha(Float.valueOf(viewType));

        return new SavedMealItemsViewHolder(v);
    }

    class SavedMealItemsViewHolder extends MealItemListAdapter.MealItemsViewHolder {
        ImageView tickIcon;

        SavedMealItemsViewHolder(final View itemView){
            super(itemView);
            tickIcon = itemView.findViewById(R.id.list_view_saved_meal_tick);
        }
    }
}
