package com.softwareoverflow.mealtimer.meal;

import com.softwareoverflow.mealtimer.meal.stubData.StubMealData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MealItemStageTest {

    private StubMealData stubMealData = new StubMealData();
    private MealItemStage mealItemStage, duplicateStage;

    @Before
    public void setUp(){
        mealItemStage = stubMealData.getStubMealItemStage();
        duplicateStage = new MealItemStage(mealItemStage.getStageName(), mealItemStage.getTime());
    }

    @Test
    public void getStageName() {
        Assert.assertEquals("Stage 1", mealItemStage.getStageName());
    }

    @Test
    public void getTime() {
        assertEquals(5, mealItemStage.getTime());
    }

    @Test
    public void checkAreEqual() {
        assertEquals("Failed on equals", mealItemStage, duplicateStage);
        assertNotEquals(mealItemStage, null);
        assertNotEquals(mealItemStage, "FAIL");

        List<MealItemStage> stages = stubMealData.getStubMealItemStages(2);
        assertNotEquals(stages.get(0), stages.get(1));
    }

    @Test
    public void checkSameHashCodes(){
        assertEquals("Should return same hash codes",
                mealItemStage.hashCode(), duplicateStage.hashCode());
    }
}