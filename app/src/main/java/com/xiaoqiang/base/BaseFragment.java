package com.xiaoqiang.base;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xiaoqiang on 2017/3/7.
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment";

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(loadLayout(),null);
        initView(view);
        initData();
        Log.d(TAG, "onCreateView: ");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    protected abstract int loadLayout();
    protected abstract void initView(View view);
    protected abstract void initData();
}
