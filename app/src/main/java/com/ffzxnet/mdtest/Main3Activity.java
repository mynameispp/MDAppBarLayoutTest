package com.ffzxnet.mdtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.WindowManager;

/**
 * 创建者： feifan.pi 在 2017/3/29.
 */

public class Main3Activity extends BaseActivity {
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_main);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initToolBar("", "第三个页面标题", true, false);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitleEnabled(false);//禁用CollapsingToolbarLayout的title，不然toolbar不会正常显示
        //悬浮按钮
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        //监听顶部收缩状态
        ((AppBarLayout) findViewById(R.id.appbar)).addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED) {
                    //展开状态
                    floatingActionButton.show();
                } else if (state == State.COLLAPSED) {
                    //折叠状态
                    floatingActionButton.hide();
                } else {
                    //中间状态
                }
            }
        });
    }
}
