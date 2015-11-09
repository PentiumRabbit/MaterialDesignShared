package com.android.materialdesignshared.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.android.materialdesignshared.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SlideActivity extends AppCompatActivity {

    @InjectView(R.id.btn_first)
    Button btnFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // inside your activity (if you did not enable transitions in your theme)
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            // set an enter transition
            // 用END在联想的手机上报错,尼玛
            getWindow().setEnterTransition(new Slide(Gravity.RIGHT).setDuration(3000));
            // set an exit transition
//            getWindow().setExitTransition(new Explode());
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(btnFirst, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
