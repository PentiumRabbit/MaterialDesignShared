package com.android.materialdesignshared.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.android.materialdesignshared.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class PathInterpolatorCompatActivity extends AppCompatActivity {

    @InjectView(R.id.iv_send)
    ImageView ivSend;
    @InjectView(R.id.btn_send)
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_interpolator_compat);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {

    }

    @OnClick(R.id.btn_send)
    void clickSend()
    {
        flyView(ivSend);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_path_interpolator_compat, menu);
        return true;
    }

    private void flyView(View iconView) {
        AnimatorSet flyUpAnim = new AnimatorSet();
        flyUpAnim.setDuration(800);

        ObjectAnimator transX = ObjectAnimator.ofFloat(iconView, "translationX", 0, 800);
        ObjectAnimator transY = ObjectAnimator.ofFloat(iconView, "translationY", 0, -600);
        transY.setInterpolator(PathInterpolatorCompat.create(0.2f, -0.7f,0.6f,-0.2f));
        ObjectAnimator rotation = ObjectAnimator.ofFloat(iconView, "rotation", -45, 0);
        rotation.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator rotationX = ObjectAnimator.ofFloat(iconView, "rotationX", 0, 60);
        rotationX.setInterpolator(new DecelerateInterpolator());

        flyUpAnim.playTogether(transX, transY, rotationX,
                ObjectAnimator.ofFloat(iconView, "scaleX", 1, 0.5f),
                ObjectAnimator.ofFloat(iconView, "scaleY", 1, 0.5f),
                rotation
        );

        flyUpAnim.start();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
