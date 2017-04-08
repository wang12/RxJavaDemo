package com.xiaoqiang.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by xiaoqiang on 2017/4/6.
 */

public final class ToastUtil {
    public static void showToast(View view, String msg){
        Snackbar.make(view,msg,Snackbar.LENGTH_SHORT).setAction("取消",new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        }).show();
    }
}
