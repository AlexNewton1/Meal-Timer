package com.softwareoverflow.mealtimer.meal;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private String mealName;
    private List<MealItem> mealItems = new ArrayList<MealItem>();

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

    public void removeMealItem(MealItem mealItem){
        mealItems.remove(mealItem);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Meal other = (Meal) obj;
        return (this.mealItems == other.mealItems && this.mealName.equals(other.mealName));
    }
}
