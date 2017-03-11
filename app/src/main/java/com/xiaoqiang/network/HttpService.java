package com.xiaoqiang.network;

import com.xiaoqiang.model.BaseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xiaoqiang on 2017/3/10.
 * 这个是封装请求类
 */

public interface HttpService {
    @GET("top250")
    Call<HttpMethods<List<BaseModel>>> getTopMovie(@Query("start")int start, @Query("count")int count);
    @GET("top250")
    Call<String> getTopMovieString(@Query("start")int start, @Query("count")int count);
    @GET("top250")
    Observable<HttpMethods<List<BaseModel>>> getTopMovieObservable(@Query("start")int start,@Query("count")int count);
}
