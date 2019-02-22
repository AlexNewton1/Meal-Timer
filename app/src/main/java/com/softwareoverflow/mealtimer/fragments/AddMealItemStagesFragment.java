package com.softwareoverflow.mealtimer.fragments;

import com.softwareoverflow.mealtimer.R;

/**
 * This fragment is responsible for linking {@link com.softwareoverflow.mealtimer.meal.MealItemStage}
 * objects to the current {@link com.softwareoverflow.mealtimer.meal.MealItem}. This allows multiple
 * steps per {@link com.softwareoverflow.mealtimer.meal.MealItem}.
 */
public class AddMealItemStagesFragment extends MealWizardFragment {


    public AddMealItemStagesFragment() {
        // TODO - change to a "go back" icon and a "tick" icon
        super(R.drawable.arrow_right_faded, R.drawable.arrow_left);
    }
}
