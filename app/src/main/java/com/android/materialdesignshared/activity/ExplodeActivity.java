package com.android.materialdesignshared.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Window;

import com.android.materialdesignshared.R;

public class ExplodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // inside your activity (if you did not enable transitions in your theme)
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            // set an enter transition
            getWindow().setEnterTransition(new Explode().setDuration(3000));
            // set an exit transition
//            getWindow().setExitTransition(new Explode());
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explode);


    }
}
