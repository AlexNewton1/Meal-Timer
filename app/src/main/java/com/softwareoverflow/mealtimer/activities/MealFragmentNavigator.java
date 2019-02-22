package com.softwareoverflow.mealtimer.activities;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageButton;

import com.softwareoverflow.mealtimer.meal.Meal;

public interface MealFragmentNavigator {

    void onNextButtonClick(View v);

    void onBackButtonClick(View v);

    void nextWizardStep();

    void previousWizardStep();

    FloatingActionButton getFAB();

    ImageButton getNextIcon();

    ImageButton getBackIcon();

    void setMeal(Meal meal);

    Meal getMeal();

}
