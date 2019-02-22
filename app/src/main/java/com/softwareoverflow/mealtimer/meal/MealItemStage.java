package com.softwareoverflow.mealtimer.meal;

import android.support.annotation.Nullable;

public class MealItemStage {

    private String stageName;
    private int time;

    public MealItemStage(String name, int time){
        stageName = name;
        this.time = time;
    }

    public String getStageName() {
        return stageName;
    }

    public int getTime() {
        return time;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        MealItemStage other = (MealItemStage) obj;
        return (this.stageName.equals(other.stageName) && this.time == other.time);
    }
}
