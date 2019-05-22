package com.softwareoverflow.mealtimer.meal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Meal {

    private Integer mealId = null;
    private String mealName;
    private List<MealItem> mealItems = new ArrayList<>();

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public List<MealItem> getMealItems() {
        return mealItems;
    }

    public void setMealItems(@NonNull List<MealItem> mealItems) {
        this.mealItems = mealItems;
    }

    public void addMealItems(List<MealItem> mealItems){
        int position = mealItems.size() - 1;
        if(position < 0) position = 0;
        this.mealItems.addAll(position, (mealItems)); // Add to end of list
    }

    public void removeMealItem(MealItem mealItem){
        mealItems.remove(mealItem);
    }

    /**
     * @return - the total time for the meal in minutes.
     * This is equivalent to the {@link MealItem} with the largest duration as meal items
     * will be completed in parallel
     */
    public int getMealDuration(){
        ArrayList<MealItem> copy = new ArrayList<>(getMealItems());
        Collections.sort(copy);
        return copy.get(0).getDuration();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Meal other = (Meal) obj;
        return (this.mealItems.equals(other.mealItems));
    }
}
