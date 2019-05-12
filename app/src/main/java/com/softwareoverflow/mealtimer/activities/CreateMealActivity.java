package com.softwareoverflow.mealtimer.activities;

import android.os.Bundle;
import android.view.View;

import com.softwareoverflow.mealtimer.MealWizardNavigator;
import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.meal.Meal;
import com.softwareoverflow.mealtimer.ui.MealViewPager;
import com.softwareoverflow.mealtimer.ui.pagerAdapters.CreateMealPagerAdapter;

public class CreateMealActivity extends MealActivity implements MealWizardNavigator {

    private MealViewPager createMealViewPager;
    private CreateMealPagerAdapter mealPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meal);

        meal = new Meal();
        createMockMeal();

        createMealViewPager = findViewById(R.id.create_meal_view_pager);
        navForward = findViewById(R.id.create_meal_nav_forward_button);
        navBackward = findViewById(R.id.create_meal_nav_back_button);
        fab = findViewById(R.id.create_meal_fab);

        mealPagerAdapter = new CreateMealPagerAdapter(getSupportFragmentManager());
        createMealViewPager.setAdapter(mealPagerAdapter);
    }

    public void onNextButtonClick(View v) {
        mealPagerAdapter.getFragment(createMealViewPager.getCurrentItem()).onNextButtonClicked();
    }

    public void onBackButtonClick(View v) {
        mealPagerAdapter.getFragment(createMealViewPager.getCurrentItem()).onBackButtonClicked();
    }

    @Override
    public void nextWizardStep() {
        if(createMealViewPager.getCurrentItem() < mealPagerAdapter.getCount())
            createMealViewPager.setCurrentItem(createMealViewPager.getCurrentItem() + 1);
        // TODO - else statement to start different activity
    }

    @Override
    public void previousWizardStep() {
        if(createMealViewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            createMealViewPager.setCurrentItem(createMealViewPager.getCurrentItem() - 1);
    }

    @Override
    public void onBackPressed() {
        onBackButtonClick(null);
    }
}
