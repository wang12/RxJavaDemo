package com.xiaoqiang.fragment;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xiaoqiang.R;
import com.xiaoqiang.base.BaseFragment;
import com.xiaoqiang.util.ViewUtils;

import rx.functions.Action1;

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
        Button button = (Button) view.findViewById(R.id.show_dialog);
        button.setVisibility(View.VISIBLE);
        ViewUtils.setAddOnClick(button).subscribe(new Action1() {
            @Override
            public void call(Object o) {
//                BaseDialog dialog = new BaseDialog();
//                dialog.show(getFragmentManager(),"BaseDialog");
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("好看的对话框");
                builder.setMessage("这个对话框真好看");
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);
                builder.show();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
