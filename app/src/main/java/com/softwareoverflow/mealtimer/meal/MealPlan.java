package com.softwareoverflow.mealtimer.meal;

import java.util.Date;

/**
 * Holds information about the meal plan - {@link Meal} & Date objects
 */
public class MealPlan {

    private Meal meal;
    private Date readyDate;

    public MealPlan(Meal meal, Date readyDate){
        this.meal = meal;
        this.readyDate = readyDate;
    }

    public Meal getMeal() {
        return meal;
    }

    public Date getReadyDate() {
        return readyDate;
    }
}
