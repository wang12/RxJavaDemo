package com.xiaoqiang;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiaoqiang.base.BaseActivity;
import com.xiaoqiang.fragment.FirstFragment;
import com.xiaoqiang.fragment.SecondFragment;
import com.xiaoqiang.fragment.ThreeFragment;
import com.xiaoqiang.util.ViewUtils;

import rx.functions.Action1;

public class MainActivity extends BaseActivity {
    private Button firstButton;
    private Button secondButton;
    private Button threeButton;
    @Override
    protected int loadLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        firstButton = (Button) findViewById(R.id.btn_first);
        secondButton = (Button) findViewById(R.id.btn_second);
        threeButton = (Button) findViewById(R.id.btn_three);
        getFragmentManager().beginTransaction().replace(R.id.fragmet_layout,new FirstFragment()).commit();
        ViewUtils.setAddOnClick(firstButton).subscribe(new Action1<View>() {
            @Override
            public void call(View o) {
                Fragment fragment = getFragmentManager().findFragmentById(R.id.fragmet_layout);
                if(!(fragment instanceof  FirstFragment)) {
                    getFragmentManager().beginTransaction().replace(R.id.fragmet_layout, new FirstFragment()).commit();
                }
            }
        });
        ViewUtils.setAddOnClick(secondButton).subscribe(new Action1<View>(){
            @Override
            public void call(View view) {
                Fragment fragment = getFragmentManager().findFragmentById(R.id.fragmet_layout);
                if(!(fragment instanceof  SecondFragment)) {
                    getFragmentManager().beginTransaction().replace(R.id.fragmet_layout, new SecondFragment()).commit();
                }
            }
        });
        ViewUtils.setAddOnClick(threeButton).subscribe(new Action1<View>(){
            @Override
            public void call(View view) {
                Fragment fragment = getFragmentManager().findFragmentById(R.id.fragmet_layout);
                if(!(fragment instanceof ThreeFragment)) {
                    getFragmentManager().beginTransaction().replace(R.id.fragmet_layout, new ThreeFragment()).commit();
                }
            }
        });
    }

    @Override
    protected void initData() {
    }
}
