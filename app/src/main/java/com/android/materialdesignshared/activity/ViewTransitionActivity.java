package com.android.materialdesignshared.activity;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.materialdesignshared.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ViewTransitionActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.btn_explore)
    Button btnExplore;
    @InjectView(R.id.btn_slide)
    Button btnSlide;
    @InjectView(R.id.btn_fade)
    Button btnFade;
    private Scene scene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_transition);
        ButterKnife.inject(this);
        initView();
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void initView() {
        setSupportActionBar(toolbar);
        ViewGroup container = (ViewGroup)findViewById(R.id.ll_content);
        TransitionInflater transitionInflater = TransitionInflater.from(this);
        TransitionManager transitionManager = transitionInflater.inflateTransitionManager(
                R.transition.transition_manager, container);

        scene = Scene.getSceneForLayout(container,
                R.layout.activity_content, this);
    }

    @OnClick(R.id.btn_explore)
    void exploreActivity() {
//        goToScene(scene);
//        startActivity(new Intent(this, ContentActivity.class));
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.btn_slide)
    void slideActivity() {
        Intent intent=new Intent(this, ContentActivity.class);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    @OnClick(R.id.btn_fade)
    void fadeActivity() {

    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void goToScene(Scene scene) {
        ChangeBounds changeBounds = new ChangeBounds();
//        Fade fadeOut = new Fade(Fade.OUT);
        Fade fadeIn = new Fade(Fade.IN);
        TransitionSet transition = new TransitionSet();
        transition.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
        transition
//                .addTransition(fadeOut)
                .addTransition(changeBounds)
                .addTransition(fadeIn);
        TransitionManager.go(scene, transition);
    }

}
