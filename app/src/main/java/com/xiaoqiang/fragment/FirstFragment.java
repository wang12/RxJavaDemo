package com.xiaoqiang.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xiaoqiang.R;
import com.xiaoqiang.base.BaseFragment;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xiaoqiang on 2017/3/8.
 */

public class FirstFragment extends BaseFragment {
    private static final String TAG = "FirstFragment";
    private TextView test;
    @Override
    protected int loadLayout() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initView(View view) {
        test = (TextView) view.findViewById(R.id.tv_test);
        test.setText("FirstFragment.........");
    }

    @Override
    protected void initData() {
//        rxTest();
//        rxTest();
        mapRxTest();
    }
//    Observer<String> observer = new Observer<String>() {
//        @Override
//        public void onCompleted() {
//            Log.d(TAG, "onCompleted: thread="+Thread.currentThread());
//        }
//
//        @Override
//        public void onError(Throwable e) {
//            Log.d(TAG, "onError: " + e.getMessage()+"thread="+Thread.currentThread());
//        }
//
//        @Override
//        public void onNext(String s) {
//            Log.d(TAG, "onNext: "+s+",thread="+Thread.currentThread());
//        }
//    };
//    Subscriber mSubscriber = new Subscriber<String>() {
//        @Override
//        public void onCompleted() {
//            Log.d(TAG, "onCompleted: thread="+Thread.currentThread());
//        }
//
//        @Override
//        public void onError(Throwable e) {
//            Log.d(TAG, "onError: " + e.getMessage()+"thread="+Thread.currentThread());
//        }
//
//        @Override
//        public void onNext(String s) {
//            Log.d(TAG, "onNext: "+s+",thread="+Thread.currentThread());
//        }
//    };
    private  void rxTest(){
        /**
         * 观察者。决定事件收到后的行为
         */

        //被观察者
//        Observable.create(new Action1<Emitter<? extends Object>>() {
//            @Override
//            public void call(Emitter<? extends Object> emitter) {
//
//            }
//        })
//        Observable.create(new AsyncOnSubscribe<String, String>() {
//            @Override
//            protected String generateState() {
//                return null;
//            }
//
//            @Override
//            protected String next(String state, long requested, Observer<Observable<? extends String>> observer) {
//                return null;
//            }
//          });
//        Observable.create(new SyncOnSubscribe<String, String>() {
//            @Override
//            protected String generateState() {
//                return null;
//            }
//
//            @Override
//            protected String next(String state, Observer<? super String> observer) {
//                return null;
//            }
//        });
        Observable observable = Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                Log.d(TAG, "call: "+",thread="+Thread.currentThread());
                subscriber.onNext("小强");
//                try {
//                   int i = 1 / 0;
//                }catch (Exception e){
//                    subscriber.onError(e);
//                }
                subscriber.onCompleted();
            }
        });
        //订阅过程， observer观察observable中的执行过程
//        observable
//                .subscribeOn(Schedulers.io()) //被观察者执行的线程
//                .observeOn(AndroidSchedulers.mainThread()) //观察者收到的回调所在线程
//                .unsubscribeOn(Schedulers.io())
//                .subscribe(mSubscriber);
    }
    private void mapRxTest(){
        Subscriber mSubscriber = new Subscriber<Integer>() {
            @Override
        public void onCompleted() {
            Log.d(TAG, "onCompleted: thread="+Thread.currentThread());
        }

        @Override
        public void onError(Throwable e) {
            Log.d(TAG, "onError: " + e.getMessage()+"thread="+Thread.currentThread());
        }

        @Override
        public void onNext(Integer s) {
            Log.d(TAG, "onNext: "+s+",thread="+Thread.currentThread());
        }
        };
        Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {
                Log.d(TAG, "call: "+",thread="+Thread.currentThread().getName());
                subscriber.onNext("小强");
            }
        }) .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<String,Integer>(){
                    @Override
                    public Integer call(String s) {
                        Log.d(TAG, "call: String  = "+s+",Thread="+Thread.currentThread().getName());
                        return 11;
                    }
                })
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mSubscriber);
    }
}
