package com.softwareoverflow.mealtimer;

import android.support.design.widget.FloatingActionButton;
import android.widget.ImageButton;

import com.softwareoverflow.mealtimer.meal.Meal;

public interface MealWizardNavigator {

    void nextWizardStep();

    void previousWizardStep();

    FloatingActionButton getFAB();

    ImageButton getNextIcon();

    ImageButton getBackIcon();

    void setMeal(Meal meal);

    Meal getMeal();

}
