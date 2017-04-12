package com.xiaoqiang.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Toast;

import com.xiaoqiang.R;
import com.xiaoqiang.util.ToastUtil;

import java.lang.reflect.Field;

/**
 * Created by xiaoqiang on 2017/3/7.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        makeActionOverflowMenuShown();
        super.onCreate(savedInstanceState);
        setContentView(loadLayout());
        initView();
        initData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_base,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void makeActionOverflowMenuShown() {
        //devices with hardware menu button (e.g. Samsung Note) don't show action overflow menu
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {

        }
    }
    protected abstract  int loadLayout();
    protected abstract void initView();
    protected abstract  void initData();
}
