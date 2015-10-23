package com.android.materialdesignshared.activity;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeTransform;
import android.transition.Transition;
import android.util.Pair;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.android.materialdesignshared.R;

public class WeightActivity extends AppCompatActivity {

    @InjectView(R.id.add_button)
    ImageButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        ButterKnife.inject(this);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initView() {
        addButton.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int shapeSize = (int) getResources().getDimension(R.dimen.shape_size);
                outline.setRoundRect(0, 0, shapeSize, shapeSize, shapeSize / 2);
            }
        });
    }


    /**
     * start detail activity
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void startActivity(final View v, final int position) {

//        View pic = v.findViewById(R.id.pic);
        View add_btn = this.findViewById(R.id.add_button);

        // set share element transition animation for current activity
        Transition ts = new ChangeTransform();
        ts.setDuration(3000);
        getWindow().setExitTransition(ts);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation( this,
//                Pair.create(pic, position + "pic"),
                Pair.create(add_btn, "ShareBtn")).toBundle();

        // start activity with share element transition
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("pos", position);
        startActivity(intent, bundle);

    }

    /**
     * create CircularReveal animation
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Animator createAnimation(View v) {
        // create a CircularReveal animation
        Animator animator = ViewAnimationUtils.createCircularReveal(
                v,
                v.getWidth() / 2,
                v.getHeight() / 2,
                0,
                v.getWidth());
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(500);
        return animator;
    }
}
