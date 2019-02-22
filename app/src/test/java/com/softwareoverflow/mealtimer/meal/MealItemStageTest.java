package com.softwareoverflow.mealtimer.meal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MealItemStageTest {

    private MealItemStage mealItemStage;

    @Before
    public void setUp(){
        mealItemStage = new MealItemStage("Test", 5);
    }

    @Test
    public void getStageName() {
        Assert.assertEquals("Test", mealItemStage.getStageName());
    }

    @Test
    public void getTime() {
        assertEquals(5, mealItemStage.getTime());
    }

    @Test
    public void equals() {
        assertEquals("Failed on equals", mealItemStage, new MealItemStage("Test", 5));
        assertNotEquals(mealItemStage, null);
        assertNotEquals(mealItemStage, "FAIL");
    }
}