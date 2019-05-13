package com.softwareoverflow.mealtimer.meal;

import com.softwareoverflow.mealtimer.meal.stubData.StubMealData;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MealPlanTest {

    private MealPlan mealPlan;
    private Meal meal;
    private Date readyDate = new Date();

    @Before
    public void setUp() throws Exception {
        meal = new StubMealData().getStubMeal();
        mealPlan = new MealPlan(meal, readyDate);
    }

    @Test
    public void getMeal() {
        assertEquals(meal, mealPlan.getMeal());
    }

    @Test
    public void getReadyDate() {
        assertEquals(readyDate, mealPlan.getReadyDate());
    }
}