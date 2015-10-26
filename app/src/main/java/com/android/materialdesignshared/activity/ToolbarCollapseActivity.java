
package com.android.materialdesignshared.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.transition.Explode;
import com.android.materialdesignshared.R;

/**
 * Make Toolbar Collapse 使工具栏可折叠
 *
 * @Description: ToolbarCollapseActivity
 * @Author: PentiumRabbit
 * @Update: PentiumRabbit(2015-10-20 18:07)
 */
public class ToolbarCollapseActivity extends AppCompatActivity {
    private static final String TAG = ToolbarCollapseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setTheme(R.style.LTheme);
        }

        setContentView(R.layout.activity_toolbar_collapse);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //设置工具栏标题
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(
                R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("cheeseName");
    }
}
