package com.softwareoverflow.mealtimer.meal;

import com.softwareoverflow.mealtimer.meal.stubData.StubMealData;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MealItemTest {

    private StubMealData stubMealData = new StubMealData();
    private MealItem mealItem, duplicateItem;

    @Before
    public void setUp() throws Exception {
        mealItem = stubMealData.getStubMealItem();
        duplicateItem = new MealItem(mealItem.getName());
    }

    @Test
    public void checkNameEquals() {
        assertEquals(mealItem.getName(), duplicateItem.getName());
    }

    @Test
    public void checkAddStages() {
        duplicateItem.addStage(stubMealData.getStubMealItemStage());

        assertEquals(1, duplicateItem.getNumStages());

        duplicateItem.addStage(stubMealData.getStubMealItemStage());
        assertEquals(2, duplicateItem.getNumStages());
    }

    @Test
    public void checkDuration() {
        assertEquals(40, mealItem.getDuration());
        assertEquals(100, stubMealData.getStubMealItems(2).get(1).getDuration());
    }

    @Test
    public void testAddStages() {
        List<MealItemStage> stages = stubMealData.getStubMealItemStages(3);
        for (int i = 0; i < stages.size(); i++){
            duplicateItem.addStage(stages.get(i));
            assertEquals(i + 1, duplicateItem.getNumStages());

            assertEquals(stages.get(i), duplicateItem.getStages().get(i));
        }
    }

    @Test
    public void checkEquality() {
        assertEquals(mealItem, duplicateItem);

        assertNotEquals(mealItem, null);
        assertNotEquals(mealItem, new Object());
    }

    @Test
    public void checkEqualHashCodes() {
        for (MealItemStage stage : mealItem.getStages())
            duplicateItem.addStage(stage);

            assertEquals(mealItem.hashCode(), duplicateItem.hashCode());
    }
}