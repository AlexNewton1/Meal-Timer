package com.softwareoverflow.mealtimer.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageButton;

import com.softwareoverflow.mealtimer.MealWizardNavigator;
import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.meal.Meal;
import com.softwareoverflow.mealtimer.meal.MealItem;
import com.softwareoverflow.mealtimer.meal.MealItemStage;
import com.softwareoverflow.mealtimer.ui.MealViewPager;
import com.softwareoverflow.mealtimer.ui.pagerAdapters.CreateMealPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CreateMealActivity extends FragmentActivity implements MealWizardNavigator {

    private Meal meal;

    private MealViewPager createMealViewPager;
    private CreateMealPagerAdapter mealPagerAdapter;
    private ImageButton navForward, navBackward;
    private FloatingActionButton fab;

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

    //TODO - remove this!
    private void createMockMeal(){
        Meal meal = new Meal();
        MealItemStage stage1 = new MealItemStage("Stage 1", 25);
        MealItemStage stage2 = new MealItemStage("Stage 2", 35);
        MealItemStage stage3 = new MealItemStage("Stage 3", 60);

        MealItem item1 = new MealItem("Item 1");
        item1.addStage(stage1);
        item1.addStage(stage2);

        MealItem item2 = new MealItem("Item 2");
        item2.addStage(stage1);
        item2.addStage(stage2);
        item2.addStage(stage3);

        MealItem item3 = new MealItem("Item 3");
        item3.addStage(stage3);

        List<MealItem> mealItemList = new ArrayList<>();
        mealItemList.add(item1);
        mealItemList.add(item2);
        mealItemList.add(item3);

        meal.setMealItems(mealItemList);

        setMeal(meal);
    }

    @Override
    public Meal getMeal() {
        return meal;
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
    public FloatingActionButton getFAB() {
        return fab;
    }

    @Override
    public ImageButton getNextIcon() {
        return navForward;
    }

    @Override
    public ImageButton getBackIcon() {
        return navBackward;
    }

    @Override
    public void setMeal(Meal meal) {
        this.meal = meal;

        //TODO - update any (list) adapters...
    }

    @Override
    public void onBackPressed() {
        onBackButtonClick(null);
    }
}
