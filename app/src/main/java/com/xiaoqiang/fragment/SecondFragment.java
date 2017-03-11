package com.xiaoqiang.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xiaoqiang.R;
import com.xiaoqiang.base.BaseFragment;
import com.xiaoqiang.model.BaseModel;
import com.xiaoqiang.network.HttpMethods;
import com.xiaoqiang.network.HttpRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;

/**
 * Created by xiaoqiang on 2017/3/8.
 */

public class SecondFragment extends BaseFragment {
    private static final String TAG = "SecondFragment";
    private TextView test;
    @Override
    protected int loadLayout() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initView(View view) {
        test = (TextView) view.findViewById(R.id.tv_test);
        test.setText("SecondFragment.........");
    }

    @Override
    protected void initData() {
        HttpRequest.getRequest().getMovie(0, 10, new Callback<HttpMethods<List<BaseModel>>>() {
            @Override
            public void onResponse(Call<HttpMethods<List<BaseModel>>> call, Response<HttpMethods<List<BaseModel>>> response) {
                Log.d(TAG, "onResponse: "+response.body()+",Thread:"+Thread.currentThread());
            }

            @Override
            public void onFailure(Call<HttpMethods<List<BaseModel>>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage()+",Thread:"+Thread.currentThread());
            }
        });
        HttpRequest.getRequest().getMovieString(0, 10, new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onResponse:String "+",Thread:"+Thread.currentThread());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage()+",Thread:"+Thread.currentThread());
            }
        });
        HttpRequest.getRequest().getMovieObservable(0, 10, new Observer<HttpMethods<List<BaseModel>>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: "+",Thread:"+Thread.currentThread());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: "+e.getMessage()+",Thread:"+Thread.currentThread());
            }

            @Override
            public void onNext(HttpMethods<List<BaseModel>> listHttpMethods) {
                Log.d(TAG, "onNext: "+"methods:"+listHttpMethods.getSubjects()+",Thread:"+Thread.currentThread());
            }
        });
    }

}
