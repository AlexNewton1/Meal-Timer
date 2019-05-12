package com.softwareoverflow.mealtimer.meal;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private int mealId;
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

    public void setMealItems(List<MealItem> mealItems) {
        this.mealItems = mealItems;
    }

    public void addMealItems(List<MealItem> mealItems){
        this.mealItems.addAll(0, (mealItems));
    }

    public void removeMealItem(MealItem mealItem){
        mealItems.remove(mealItem);
    }

    /**
     * @return - the total time for the meal in minutes
     */
    public int getMealDuration(){
        int time = 0;
        for(MealItem item : mealItems){
            int mealItemTime = item.getDuration();
            if(mealItemTime > time)
                time = mealItemTime;
        }

        return time;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Meal other = (Meal) obj;
        return (this.mealItems.equals(other.mealItems) && this.mealName.equals(other.mealName));
    }
}
