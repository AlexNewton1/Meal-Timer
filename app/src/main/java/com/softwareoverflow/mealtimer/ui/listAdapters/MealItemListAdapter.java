package com.softwareoverflow.mealtimer.ui.listAdapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softwareoverflow.mealtimer.R;
import com.softwareoverflow.mealtimer.meal.MealItem;

import java.util.List;
import java.util.Locale;

public class MealItemListAdapter extends RecyclerView.Adapter<MealItemListAdapter.MealItemsViewHolder> {

    private List<MealItem> mealItems;

    public MealItemListAdapter(List<MealItem> mealItems){
        this.mealItems = mealItems;
    }

    @NonNull
    @Override
    public MealItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_add_meal_items, parent, false);
        return new MealItemsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MealItemsViewHolder viewHolder, int position) {
        MealItem mealItem = mealItems.get(position);

        viewHolder.mealItemNameTV.setText(mealItem.getName());
        viewHolder.numStagesTV.setText(String.valueOf(mealItem.getNumStages()));

        int duration = mealItem.getDuration();
        viewHolder.durationTV.setText(String.format(Locale.getDefault(),
                "%02d:%02d", duration / 60, duration % 60));

        // TODO - change to correct icons
        viewHolder.listIcon.setImageResource(R.drawable.icon_arrow_left);
        viewHolder.clockIcon.setImageResource(R.drawable.launcher);
    }

    @Override
    public int getItemCount() {
        return mealItems.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    class MealItemsViewHolder extends RecyclerView.ViewHolder {
        TextView mealItemNameTV, numStagesTV, durationTV;
        ImageView listIcon, clockIcon;

        MealItemsViewHolder(View itemView){
            super(itemView);

            mealItemNameTV = itemView.findViewById(R.id.meal_item_name_text_view);
            numStagesTV = itemView.findViewById(R.id.list_view_meal_item_num_stages);
            durationTV = itemView.findViewById(R.id.list_view_meal_item_duration);

            listIcon = itemView.findViewById(R.id.list_view_meal_item_list_icon);
            clockIcon = itemView.findViewById(R.id.list_view_meal_item_clock_icon);
        }
    }
}
