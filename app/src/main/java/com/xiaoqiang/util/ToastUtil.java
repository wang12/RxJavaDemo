package com.xiaoqiang.util;

import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaoqiang.R;

/**
 * Created by xiaoqiang on 2017/4/6.
 */

public final class ToastUtil {
    private static Snackbar bar;
    public static void showToast(View view, String msg){
        bar = Snackbar.make(view,msg,10*1000);
        bar.setActionTextColor(0xffff00ff);
        bar.addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
            @Override
            public void onDismissed(Snackbar transientBottomBar, int event) {
                Log.d("wqq","Snackbar 消时了");
            }

            @Override
            public void onShown(Snackbar transientBottomBar) {
                Log.d("wqq","Snackbar 显示了");
            }
        });
        bar.getView().setBackgroundColor(0xff0000ff);
        ((TextView)bar.getView().findViewById(android.support.design.R.id.snackbar_text)).setTextColor(0xffff0000);

        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) bar.getView();
        ImageView image = new ImageView(bar.getContext());
        image.setBackgroundColor(0x00ffffff);
        image.setImageResource(R.drawable.xingxing);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL|Gravity.RIGHT;
        layout.addView(image,params);
        bar.show();
    }
}
