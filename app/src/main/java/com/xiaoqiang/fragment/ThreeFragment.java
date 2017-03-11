package com.xiaoqiang.fragment;

import android.view.View;
import android.widget.TextView;

import com.xiaoqiang.R;
import com.xiaoqiang.base.BaseFragment;

/**
 * Created by xiaoqiang on 2017/3/8.
 */

public class ThreeFragment extends BaseFragment {
    private TextView test;
    @Override
    protected int loadLayout() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initView(View view) {
        test = (TextView) view.findViewById(R.id.tv_test);
        test.setText("ThreeFragment.........");
    }

    @Override
    protected void initData() {

    }
}
