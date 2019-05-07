package com.softwareoverflow.mealtimer.fragments.mealItems;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SearchView;

import com.softwareoverflow.mealtimer.FragmentCancellable;
import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.fragments.MealWizardFragment;
import com.softwareoverflow.mealtimer.meal.Meal;
import com.softwareoverflow.mealtimer.meal.MealItem;
import com.softwareoverflow.mealtimer.meal.MealItemStage;
import com.softwareoverflow.mealtimer.ui.RecyclerItemClickListener;
import com.softwareoverflow.mealtimer.ui.animator.TickChangeAnimationListener;
import com.softwareoverflow.mealtimer.ui.listAdapters.MealItemListAdapter;
import com.softwareoverflow.mealtimer.ui.listAdapters.SavedMealItemListAdapter;

import java.util.ArrayList;
import java.util.List;

public class SavedMealItemsFragment extends MealWizardFragment implements FragmentCancellable {

    private List<MealItem> savedMealItems = new ArrayList<>();

    private List<MealItem> mealItemsToAdd = new ArrayList<>();
    private List<MealItem> mealItemsToRemove = new ArrayList<>();

    private SearchView searchView;
    private MealItemListAdapter adapter;
    private  RecyclerView mealItemsRV;

    public SavedMealItemsFragment(){
        super(R.drawable.icon_tick, R.drawable.icon_undo);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_meal_items, container, false);

        this.searchView = view.findViewById(R.id.saved_meal_items_search_view);
        searchView.clearFocus();

        this.savedMealItems = getSavedMealItems(); // TODO - change this to be saved meal items
        setupRecyclerView(view);

        return view;
    }

    private void setupRecyclerView(View view){
        adapter = new SavedMealItemListAdapter(savedMealItems, mealWizardNavigatorActivity.getMeal());

        mealItemsRV = view.findViewById(R.id.fragment_meal_items_recycler_view);

        mealItemsRV.addItemDecoration(new DividerItemDecoration(mealItemsRV.getContext(),
                DividerItemDecoration.VERTICAL));

        mealItemsRV.setAdapter(adapter);
        mealItemsRV.setLayoutManager(new LinearLayoutManager(getContext()));
        mealItemsRV.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));

        mealItemsRV.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mealItemsRV,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        AppCompatImageView tickIcon =
                                view.findViewById(R.id.list_view_saved_meal_tick);

                        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
                        animator.setDuration(500);
                        animator.addUpdateListener(new TickChangeAnimationListener(tickIcon));

                        MealItem mealItem = savedMealItems.get(position);

                        if(tickIcon.getAlpha() == 1.0f){ // remove meal item from meal
                            if(mealItemsToAdd.contains(mealItem))
                                mealItemsToAdd.remove(mealItem);
                            else
                                mealItemsToRemove.add(mealItem);

                            animator.reverse();
                        } else if (tickIcon.getAlpha() == 0f){ // add meal item
                            if(mealItemsToRemove.contains(mealItem))
                                mealItemsToRemove.remove(mealItem);
                            else
                                mealItemsToAdd.add(mealItem);

                            animator.start();
                        }
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // TODO - handle long click items - edit meal item probably?
                    }
                }));
    }

    //TODO - change this method to get real meal items rather than a stub!
    private List<MealItem> getSavedMealItems(){
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

        MealItem item4 = new MealItem("Item 4");
        item3.addStage(stage1);

        List<MealItem> mealItemList = new ArrayList<>();
        mealItemList.add(item1);
        mealItemList.add(item2);
        mealItemList.add(item3);
        mealItemList.add(item4);

        return mealItemList;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(getUserVisibleHint()){
            adapter.notifyDataSetChanged();
            mealItemsRV.setAdapter(adapter);
        }

        if(searchView != null)
            searchView.clearFocus();
    }


    @Override
    public void onNegativeButtonClicked(ViewPager viewPager) {
        mealItemsToRemove.clear();
        mealItemsToAdd.clear();

        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }

    @Override
    public void onPositiveButtonClicked(ViewPager viewPager) {
        Meal meal = mealWizardNavigatorActivity.getMeal();
        meal.addMealItems(mealItemsToAdd);
        for (MealItem toRemove : mealItemsToRemove)
            meal.getMealItems().remove(toRemove);

        // go back to previous screen with any additions / changes
        onNegativeButtonClicked(viewPager);
    }


}
