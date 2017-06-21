package com.ffzxnet.mdtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 创建者： feifan.pi 在 2017/3/29.
 */

public class BaseActivity extends AppCompatActivity {
    private boolean hasMenu;//是否显示菜单

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    /**
     * 初始化ToolBar
     *
     * @param hasBack 是否显示返回按钮
     * @param hasMenu 是否显示菜单按钮
     */
    public void initToolBar(String back_title, String title, boolean hasBack, boolean hasMenu) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(back_title);
        setSupportActionBar(toolbar);
        ((TextView) findViewById(R.id.title_name)).setText(title);
        if (hasBack) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.hasMenu = hasMenu;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (hasMenu) {
            getMenuInflater().inflate(R.menu.toolbar_menu, menu);
            return true;
        } else {
            return super.onCreateOptionsMenu(menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //返回按钮
                Toast.makeText(this, "s", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item1:
                Toast.makeText(this, "aaaaaaaaaaa", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
