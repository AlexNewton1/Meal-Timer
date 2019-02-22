package com.softwareoverflow.mealtimer.fragments;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.meal.MealItem;
import com.softwareoverflow.mealtimer.ui.RecyclerItemClickListener;
import com.softwareoverflow.mealtimer.ui.listAdapters.MealItemListAdapter;

import java.util.ArrayList;
import java.util.List;

public class SavedMealItemsFragment extends MealWizardFragment implements RecyclerView.OnItemTouchListener{

    private List<MealItem> mealItems = new ArrayList<>();
    private List<MealItem> mealItemsSelected = new ArrayList<>();

    public SavedMealItemsFragment() {
        super(R.drawable.tick_icon_green, R.drawable.arrow_left);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_meal_items, container, false);

        this.mealItems = mealFragmentNavigatorActivity.getMeal().getMealItems(); // TODO - change this to be saved meal items

        final MealItemListAdapter adapter = new MealItemListAdapter(mealItems);

        final RecyclerView mealItemsRV = view.findViewById(R.id.fragment_meal_items_recycler_view);
        mealItemsRV.addItemDecoration(new DividerItemDecoration(mealItemsRV.getContext(),
                DividerItemDecoration.VERTICAL));

        mealItemsRV.setAdapter(adapter);
        mealItemsRV.setLayoutManager(new LinearLayoutManager(getContext()));
        mealItemsRV.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        mealItemsRV.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), mealItemsRV,
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                TransitionDrawable transitionDrawable = (TransitionDrawable)
                        view.findViewById(R.id.list_view_saved_meal_tick).getBackground();

                MealItem mealItem = mealItems.get(position);
                if(mealItemsSelected.contains(mealItem)){
                   mealItemsSelected.remove(mealItem);
                   transitionDrawable.reverseTransition(250);
                } else {
                    mealItemsSelected.add(mealItem);
                    transitionDrawable.startTransition(250);
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        return view;
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
//        View childView = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
//        if(childView != null )



        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {}

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {}
}
