package com.softwareoverflow.mealtimer.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageButton;

import com.softwareoverflow.mealtimer.MealWizardNavigator;
import com.softwareoverflow.mealtimer.meal.Meal;
import com.softwareoverflow.mealtimer.meal.MealItem;
import com.softwareoverflow.mealtimer.meal.MealItemStage;

import java.util.ArrayList;
import java.util.List;

public abstract class MealActivity extends FragmentActivity implements MealWizardNavigator {

    Meal meal;
    ImageButton navForward, navBackward;
    FloatingActionButton fab;

    @Override
    public Meal getMeal() {
        return meal;
    }

    //TODO - remove this!
    public void createMockMeal() {
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

        this.meal = meal;
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
}
