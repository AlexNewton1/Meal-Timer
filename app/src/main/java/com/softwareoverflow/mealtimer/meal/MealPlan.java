package com.softwareoverflow.mealtimer.meal;

import java.util.Date;

/**
 * Holds information about the meal plan
 */
public class MealPlan {
    private Meal meal;
    private Date readyDate;

    public MealPlan(Meal meal, Date readyDate){
        this.meal = meal;
        this.readyDate = readyDate;
    }
}
