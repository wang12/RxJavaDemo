package com.xiaoqiang.util;

import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;

import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;

import static rx.android.MainThreadSubscription.verifyMainThread;

/**
 * Created by xiaoqiang on 2017/3/10.
 */

public class ViewOnClieckSubscriber implements Observable.OnSubscribe<View> {
    private static final String TAG = "ViewOnClieckSubscriber";
    private WeakReference<View> view;

    public ViewOnClieckSubscriber(View v) {
        view = new WeakReference<View>(v);
    }

    @Override
    public void call(final Subscriber<? super View> subscriber) {
        verifyMainThread();
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!subscriber.isUnsubscribed() && view.get() != null) {
                    subscriber.onNext(view.get());
                }
            }
        };
        Log.d(TAG, "call: "+this);
        subscriber.add(new MainThreadSubscription() {
            @Override
            protected void onUnsubscribe() {
                Log.d(TAG, "onUnsubscribe: ");
                if (view.get() != null)
                    view.get().setOnClickListener(null);
            }
        });
        if (view.get() != null)
            view.get().setOnClickListener(listener);
    }
}
