package com.softwareoverflow.mealtimer.meal.stubData;

import com.softwareoverflow.mealtimer.meal.Meal;
import com.softwareoverflow.mealtimer.meal.MealItem;
import com.softwareoverflow.mealtimer.meal.MealItemStage;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to return stub data for the purposes of unit testing
 */
public class StubMealData {

    private Meal meal;
    private List<MealItem> mealItems;
    private List<MealItemStage> mealItemStages;

    public StubMealData(){
        createMockMeal();
    }

    private void createMockMeal() {
        meal = new Meal();

        mealItemStages = new ArrayList<>();
        MealItemStage stage1 = new MealItemStage("Stage 1", 5);
        MealItemStage stage2 = new MealItemStage("Stage 2", 35);
        MealItemStage stage3 = new MealItemStage("Stage 3", 60);

        mealItemStages.add(stage1);
        mealItemStages.add(stage2);
        mealItemStages.add(stage3);

        MealItem item1 = new MealItem("Item 1");
        item1.addStage(stage1);
        item1.addStage(stage2);

        MealItem item2 = new MealItem("Item 2");
        item2.addStage(stage1);
        item2.addStage(stage2);
        item2.addStage(stage3);

        MealItem item3 = new MealItem("Item 3");
        item3.addStage(stage3);

        mealItems = new ArrayList<>();
        mealItems.add(item1);
        mealItems.add(item2);
        mealItems.add(item3);

        meal.setMealItems(mealItems);
    }

    public Meal getStubMeal(){
        return meal;
    }

    public MealItem getStubMealItem(){
        return mealItems.get(0);
    }

    public List<MealItem> getStubMealItems(int numItems){
        return mealItems.subList(0, numItems);
    }

    public MealItemStage getStubMealItemStage(){
        return mealItemStages.get(0);
    }

    public List<MealItemStage> getStubMealItemStages(int numStages){
        return mealItemStages.subList(0, numStages);
    }
}
