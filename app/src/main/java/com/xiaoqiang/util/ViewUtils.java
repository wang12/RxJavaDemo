package com.xiaoqiang.util;


import android.view.View;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created by xiaoqiang on 2017/3/9.
 */

public class ViewUtils {
    public  static Observable setAddOnClick(final View view){
        return Observable.create(new ViewOnClieckSubscriber(view)).throttleFirst(500, TimeUnit.MILLISECONDS);
    }
}
