package com.ffzxnet.mdtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * 创建者： feifan.pi 在 2017/3/29.
 */

public class Main2Activity extends BaseActivity implements View.OnClickListener{
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        //顶部透明，颜色根据AppBarLayout来改变
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initToolBar("", "第二个页面标题", true, true);
//        ((Toolbar) findViewById(R.id.toolbar)).setBackgroundColor(getResources().getColor(R.color.colorAccent));
        ((LinearLayout) findViewById(R.id.card_lay)).getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                startActivity(new Intent(v.getContext(), Main3Activity.class));
            }
        });
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(this);

        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.scroll_2);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > 720) {
                    if (!floatingActionButton.isShown()) {
                        floatingActionButton.show();
                    }
                } else {
                    if (floatingActionButton.isShown()) {
                        floatingActionButton.hide();
                    }
                }
            }
        });
    }
    public void fabClick(){
        Snackbar.make(findViewById(R.id.coord),"你再说啥子哦",Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        fabClick();
    }
}
