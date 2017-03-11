package com.xiaoqiang.network;

import com.xiaoqiang.model.BaseModel;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xiaoqiang on 2017/3/10.
 */

public class HttpRequest {
    private static HttpRequest httpRequest;
    private HttpService httpService;
    private  SSLContext sslContext = null;

    public static HttpRequest getRequest() {
        if (httpRequest == null) {
            httpRequest = new HttpRequest();
        }
        return httpRequest;
    }

    private final static String BASE_URL = "https://api.douban.com/v2/movie/";

    private HttpRequest() {
        sslSocket();
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                //以下部分是清除HTTPS 证书验证办法
                .sslSocketFactory(sslContext.getSocketFactory())
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                //增加String字符串支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //添加OKHttp支持，这个不是必须的
                .client(builder.build())
                .build();

        httpService = retrofit.create(HttpService.class);
    }

    private void sslSocket(){
        X509TrustManager xtm = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                X509Certificate[] x509Certificates = new X509Certificate[0];
                return x509Certificates;
            }
        };

        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public void getMovie(int start, int count, Callback<HttpMethods<List<BaseModel>>> callback){
       Call<HttpMethods<List<BaseModel>>> call =  httpService.getTopMovie(start,count);
        call.enqueue(callback);
    }
    public void getMovieString(int start, int count, Callback<String> callback){
        Call<String> call =  httpService.getTopMovieString(start,count);
        call.enqueue(callback);
    }
    public void getMovieObservable(int start, int count, Observer<HttpMethods<List<BaseModel>>> observer){
        httpService.getTopMovieObservable(start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(observer);
    }

}
