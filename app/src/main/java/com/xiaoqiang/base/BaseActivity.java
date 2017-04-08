package com.xiaoqiang.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by xiaoqiang on 2017/3/7.
 */

public abstract class BaseActivity extends AppCompatActivity {
//    protected View view;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(loadLayout());
//        setContentView(R.layout.base_layout);
//        view = View.inflate(this,loadLayout(), (ViewGroup) findViewById(R.id.main));
        initView();
        initData();
//        getFragmentManager().beginTransaction().replace();

    }
    protected abstract  int loadLayout();
    protected abstract void initView();
    protected abstract  void initData();
}
