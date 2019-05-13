package com.softwareoverflow.mealtimer.meal;

import com.softwareoverflow.mealtimer.meal.stubData.StubMealData;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class MealTest {

    private Meal meal;
    private StubMealData stubMealData = new StubMealData();

    @Before
    public void setUp() throws Exception {
        meal = stubMealData.getStubMeal();
    }

    @Test
    public void getSetMealName() {
        assertNull(meal.getMealName());

        meal.setMealName("Meal Name Here");
        assertEquals("Meal Name Here", meal.getMealName());
    }


    @Test
    public void getSetMealItems() {
        assertEquals(stubMealData.getStubMealItems(3), meal.getMealItems());

        List<MealItem> mealItems = stubMealData.getStubMealItems(2);
        meal.setMealItems(mealItems);
        assertEquals(mealItems, meal.getMealItems());
    }

    @Test
    public void addMealItems() {
        int numItems = meal.getMealItems().size();
        meal.addMealItems(stubMealData.getStubMealItems(2));
        assertEquals(numItems + 2, meal.getMealItems().size());
    }

    @Test
    public void removeMealItem() {
        int numItems = meal.getMealItems().size();
        meal.removeMealItem(stubMealData.getStubMealItem());
        assertEquals(numItems - 1, meal.getMealItems().size());
    }

    @Test
    public void getMealDuration() {
        List<MealItem> mealItems = stubMealData.getStubMealItems(3);
        Collections.sort(mealItems);
        int duration = mealItems.get(0).getDuration();

        assertEquals(duration, meal.getMealDuration());
    }

    @Test
    public void equals() {
        assertNotEquals(meal, null);
        assertNotEquals(meal, new Random());

        Meal otherMeal = new Meal();
        otherMeal.addMealItems(new ArrayList<MealItem>() {
            {
                add(new MealItem("Blah"));
            }
        });

        assertNotEquals(meal, otherMeal);

        otherMeal.setMealItems(meal.getMealItems());
        assertEquals(meal, otherMeal);
    }
}