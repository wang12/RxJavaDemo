package com.xiaoqiang.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by xiaoqiang on 2017/3/7.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(loadLayout());
        initView();
        initData();
//        getFragmentManager().beginTransaction().replace();

    }
    protected abstract  int loadLayout();
    protected abstract void initView();
    protected abstract  void initData();
}
