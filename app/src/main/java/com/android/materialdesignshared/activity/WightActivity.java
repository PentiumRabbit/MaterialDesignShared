package com.android.materialdesignshared.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.widget.EditText;
import android.widget.TextView;

import com.android.materialdesignshared.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WightActivity extends AppCompatActivity {

    @InjectView(R.id.section_label)
    TextView sectionLabel;
    @InjectView(R.id.til_name)
    TextInputLayout tilName;
    @InjectView(R.id.til_pwd)
    TextInputLayout tilPwd;
    @InjectView(R.id.fab_button)
    FloatingActionButton fabButton;
    @InjectView(R.id.switchcompat)
    SwitchCompat switchcompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wight);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        EditText et_content = tilName.getEditText();
        tilName.setHint("请输入用户名");
        tilName.setError("密码输入错啦！");
        tilName.setErrorEnabled(true);//当设置成false的时候 错误信息不显示 反之显示

        fabButton.setRippleColor(Color.GRAY);//设置按下去的波纹颜色
        fabButton.setImageResource(android.R.drawable.ic_menu_add);
    }

}
