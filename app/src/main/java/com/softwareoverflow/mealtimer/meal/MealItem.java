package com.softwareoverflow.mealtimer.meal;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MealItem {

    private String itemName;
    private List<MealItemStage> stages = new ArrayList<>();

    public MealItem(String name){
        this.itemName = name;
    }

    public void addStage(MealItemStage stage){
        stages.add(stage);
    }

    public void removeStage(MealItemStage stage){
        stages.remove(stage);
    }

    public void reorderStage(MealItemStage stage, int newPos){
        stages.remove(stage);
        stages.add(newPos, stage);
    }

    public List<MealItemStage> getStages() {
        return stages;
    }

    public int getNumStages() { return stages.size(); }

    public String getName(){ return itemName; }

    public int getDuration() {
        int duration = 0;
        for(MealItemStage stage : stages){
            duration += stage.getTime();
        }

        return duration;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        MealItem other = (MealItem) obj;
        return this.itemName.equals(other.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, stages);
    }
}
