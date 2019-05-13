package com.softwareoverflow.mealtimer.meal;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a single part of the meal. Each MealItem can contain 1 or more
 * {@link MealItemStage} objects.
 */
public class MealItem implements Comparable<MealItem> {

    private String itemName;
    private List<MealItemStage> stages = new ArrayList<>();

    /**
     * @param name - name of the MealItem. Acts as the unique identifier so no 2 MealItem objects
     *             can have the same name.
     */
    public MealItem(String name) {
        this.itemName = name;
    }

    public void addStage(MealItemStage stage) {
        stages.add(stage);
    }

    //TODO - uncomment when needed, and write unit tests as well.
    /*public void removeStage(MealItemStage stage){
        stages.remove(stage);
    }

    public void reorderStage(MealItemStage stage, int newPos){
        stages.remove(stage);
        stages.add(newPos, stage);
    }
    */

    public List<MealItemStage> getStages() {
        return stages;
    }

    public int getNumStages() {
        return stages.size();
    }

    public String getName() {
        return itemName;
    }

    public int getDuration() {
        int duration = 0;
        for (MealItemStage stage : stages) {
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

    @Override
    public int compareTo(MealItem other) {
        return Integer.compare(other.getDuration(), this.getDuration());
    }
}
