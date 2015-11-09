package com.android.materialdesignshared.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeScroll;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Transition;
import android.util.LayoutDirection;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.materialdesignshared.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ImageSharedActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.iv_pic)
    ImageView ivPic;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.fab)
    FloatingActionButton fab;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // inside your activity (if you did not enable transitions in your theme)
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            // set an enter transition
//            getWindow().setEnterTransition(new Explode());
            // set an exit transition
//            getWindow().setExitTransition(new Explode());

            Transition ts = new ChangeImageTransform();
            ts.setDuration(3000);
            ts.setStartDelay(1000);
            getWindow().setSharedElementEnterTransition(ts);

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_shared);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            position = getIntent().getIntExtra("pos", 0);
            ivPic.setImageResource(position);
            ivPic.setTransitionName("pic");
            fab.setTransitionName("ShareBtn");

        }



    }

}
