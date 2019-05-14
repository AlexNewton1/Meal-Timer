package com.softwareoverflow.mealtimer.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageButton;

import com.softwareoverflow.mealtimer.FragmentCancellable;
import com.softwareoverflow.mealtimer.MealWizardNavigator;
import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.fragments.MealWizardFragment;
import com.softwareoverflow.mealtimer.meal.Meal;
import com.softwareoverflow.mealtimer.meal.MealItem;
import com.softwareoverflow.mealtimer.meal.MealItemStage;
import com.softwareoverflow.mealtimer.ui.MealViewPager;
import com.softwareoverflow.mealtimer.ui.pagerAdapters.MealItemsControllerPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the creation and modification of {@link Meal} objects
 * through a series of fragments
 */
public class MealWizardActivity extends FragmentActivity
        implements MealWizardNavigator, View.OnClickListener {

    private MealViewPager mealWizardViewPager;
    private MealItemsControllerPagerAdapter wizardPagerAdapter;

    private Meal meal;
    private ImageButton navForward, navBackward;
    private FloatingActionButton fab;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_wizard);

        meal = new Meal();
        createMockMeal();

        mealWizardViewPager = findViewById(R.id.create_meal_view_pager);
        navForward = findViewById(R.id.create_meal_nav_forward_button);
        navBackward = findViewById(R.id.create_meal_nav_back_button);
        fab = findViewById(R.id.create_meal_fab);

        wizardPagerAdapter = new MealItemsControllerPagerAdapter(getSupportFragmentManager());
        mealWizardViewPager.setAdapter(wizardPagerAdapter);

        getFAB().setOnClickListener(this);
    }

    public void onNextButtonClick(View v) {
        int currentItem = mealWizardViewPager.getCurrentItem();

        MealWizardFragment fragment = wizardPagerAdapter.getFragment(currentItem);
        if (currentItem == 0)
            nextWizardStep();
        else
            try{
                ((FragmentCancellable) fragment).onPositiveButtonClicked(mealWizardViewPager);
            } catch (ClassCastException e){
                e.printStackTrace();
                throw new ClassCastException("Meal Wizard stages should implement FragmentCancellable");
            }
    }

    public void onBackButtonClick(View v) {
        int currentItem = mealWizardViewPager.getCurrentItem();

        MealWizardFragment fragment = wizardPagerAdapter.getFragment(currentItem);
        if(fragment instanceof FragmentCancellable)
            ((FragmentCancellable) fragment).onNegativeButtonClicked(mealWizardViewPager);
        else if(currentItem == 0)
            previousWizardStep();
        else
            mealWizardViewPager.setCurrentItem(currentItem - 1);
    }

    @Override
    public void onClick(View v) {
        mealWizardViewPager.setCurrentItem(mealWizardViewPager.getCurrentItem() + 1);
    }

    @Override
    public void nextWizardStep() {
        if(mealWizardViewPager.getCurrentItem() < wizardPagerAdapter.getCount())
            mealWizardViewPager.setCurrentItem(mealWizardViewPager.getCurrentItem() + 1);
        // TODO - else statement to start different activity
    }

    @Override
    public void previousWizardStep() {
        if(mealWizardViewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            mealWizardViewPager.setCurrentItem(mealWizardViewPager.getCurrentItem() - 1);
    }

    @Override
    public void onBackPressed() {
        onBackButtonClick(null);
    }

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

}
