package com.xiaoqiang.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by xiaoqiang on 2017/4/12.
 */

public class BottomBehavior extends CoordinatorLayout.Behavior<FrameLayout>  {

    public BottomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FrameLayout child, View dependency) {
        return dependency instanceof BottomLinearLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FrameLayout child, View dependency) {
        ViewCompat.setPaddingRelative(child,0,0,0,dependency.getBottom()-dependency.getTop());
        return false;
    }
}
