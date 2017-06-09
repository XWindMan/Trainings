package com.windman.trainings.UI.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.windman.trainings.R;

public class SpalshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        final View root = findViewById(R.id.root);
        final ImageView imageView = (ImageView) findViewById(R.id.img);

        Animation animationAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha_chang);
        final Animation animationRoate = AnimationUtils.loadAnimation(this, R.anim.roate_chang);
        root.setAnimation(animationAlpha);

        final MyYAnimation myYAnimation = new MyYAnimation();
        myYAnimation.setRepeatCount(Animation.INFINITE);
        animationAlpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                root.startAnimation(myYAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animationAlpha.start();
    }
}
