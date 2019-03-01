package com.softwareoverflow.mealtimer.ui.animator;

import android.animation.ValueAnimator;
import android.widget.ImageView;

public class TickChangeAnimationListener implements ValueAnimator.AnimatorUpdateListener {

    final float[] from = new float[3],
            to =   new float[3];


    private ImageView svg;

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        svg.setAlpha(animation.getAnimatedFraction());
    }

    public TickChangeAnimationListener(final ImageView svg){
        this.svg = svg;
    }


}
