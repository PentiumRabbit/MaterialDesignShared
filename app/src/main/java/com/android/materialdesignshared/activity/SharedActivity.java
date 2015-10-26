package com.android.materialdesignshared.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeTransform;
import android.transition.Transition;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;

import com.android.materialdesignshared.R;
import com.android.materialdesignshared.adapter.ImageAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SharedActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.rv_list)
    RecyclerView rvList;
    @InjectView(R.id.fab)
    FloatingActionButton fab;
    private ImageAdapter imageAdapter;

    private int[] images = {R.drawable.pic1 , R.drawable.pic2 , R.drawable.pic3 , R.drawable.pic4 , R.drawable.pic5 , R.drawable.pic6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);
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

        // Setup list
        rvList.setLayoutManager(new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL));
        imageAdapter = new ImageAdapter(this);
        rvList.setHasFixedSize(true);
        rvList.setItemViewCacheSize(6);
        //设置Item增加、移除动画
        rvList.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
//        rvList.addItemDecoration(new ItemTouchHelper(
//               ).);
        rvList.setAdapter(imageAdapter);
        imageAdapter.update(images);

    }


    private void startActivity(View view,int position) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // set share element transition animation for current activity
            Transition ts = new ChangeTransform();
            ts.setDuration(3000);
//            getWindow().setExitTransition(ts);
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this,
                    Pair.create(view, "pic"),
                    Pair.create((View)fab, "ShareBtn")).toBundle();

            // start activity with share element transition
            Intent intent = new Intent(this, ImageSharedActivity.class);
            intent.putExtra("pos", images[position]);
            startActivity(intent, bundle);
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, view, "fab_button");
        } else {
            // 小于L版本的,正常启动
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(view,position);
    }
}
