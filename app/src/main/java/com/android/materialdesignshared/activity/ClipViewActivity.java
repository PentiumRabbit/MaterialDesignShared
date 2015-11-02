package com.android.materialdesignshared.activity;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.materialdesignshared.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ClipViewActivity extends AppCompatActivity {


    @InjectView(R.id.iv_pic)
    ImageView ivPic;
    @InjectView(R.id.btn_reveal)
    Button btnReveal;
    @InjectView(R.id.btn_Clip)
    Button btnClip;
    @InjectView(R.id.tv_clip)
    TextView tvClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_view);
        ButterKnife.inject(this);
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {


    }

    @OnClick(R.id.btn_reveal)
    void clickBtnReveal() {
        Animator animation = createAnimation(ivPic);
        animation.start();
    }

    @OnClick(R.id.btn_Clip)
    void clickBtnClip() {
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {

                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 30);
            }
        };
        ViewOutlineProvider viewOutlineProvider1 = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {

                outline.setRoundRect(0, 0, view.getWidth() , view.getHeight(), view.getHeight() / 2);
            }
        };

        tvClip.setClipToOutline(true);
        if (System.currentTimeMillis()%2==0)
        {
            tvClip.setOutlineProvider(viewOutlineProvider1);
        }else
        {
            tvClip.setOutlineProvider(viewOutlineProvider);
        }
        tvClip.invalidate();
    }

    /**
     * create CircularReveal animation
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Animator createAnimation(View v) {
        // create a CircularReveal animation
        Animator animator = ViewAnimationUtils.createCircularReveal(
                v,
                100,
                v.getHeight() / 2,
                0,
                v.getWidth());
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(2000);
        return animator;
    }

}
