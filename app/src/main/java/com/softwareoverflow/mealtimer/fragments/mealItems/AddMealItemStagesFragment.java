package com.softwareoverflow.mealtimer.fragments.mealItems;

import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.fragments.MealWizardFragment;

/**
 * This fragment is responsible for linking {@link com.softwareoverflow.mealtimer.meal.MealItemStage}
 * objects to the current {@link com.softwareoverflow.mealtimer.meal.MealItem}. This allows multiple
 * steps per {@link com.softwareoverflow.mealtimer.meal.MealItem}.
 */
public class AddMealItemStagesFragment extends MealWizardFragment {

    public AddMealItemStagesFragment() {
        super(R.drawable.icon_tick, R.drawable.icon_undo);
    }
}
