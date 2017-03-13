package com.xiaoqiang.base;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.xiaoqiang.R;
import com.xiaoqiang.util.ViewUtils;

import rx.functions.Action1;

/**
 * Created by xiaoqiang on 2017/3/7.
 */

public class BaseDialog extends DialogFragment {
    private static final String TAG = "BaseDialog";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.dialog_base,null);
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewUtils.setAddOnClick(getView().findViewById(R.id.btn_dialog_cancel)).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.d(TAG, "call cancel ");
                BaseDialog.this.dismiss();
            }
        });
        ViewUtils.setAddOnClick(getView().findViewById(R.id.btn_dialog_confirm)).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.d(TAG, "call confirm ");
                BaseDialog.this.dismiss();
            }
        });
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
