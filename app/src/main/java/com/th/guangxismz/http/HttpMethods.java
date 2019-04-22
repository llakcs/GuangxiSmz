package com.th.guangxismz.http;

import com.th.guangxismz.Bean.CommonSendBo;
import com.th.guangxismz.utils.LogUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by jelly on 2018/3/23.
 */

public class HttpMethods {
    private static final String TAG = "HttpMethods";
    private static String serverUrl;
    private Retrofit retrofit;
    private DeviceApi deviceApi;
    private int RETRY_COUNT = 0;
    private String mUrl;
    private CommonSendBo sendBo;
    private static class RxHoler {
        private static final HttpMethods instance = new HttpMethods();
    }

    public static HttpMethods getInstance() {
        return HttpMethods.RxHoler.instance;
    }

//    public HttpMethods setBaseUrl(String url){
//        this.mUrl = url;
//        return this;
//    }

    public HttpMethods setSendBo(CommonSendBo sendBo){
        this.sendBo = sendBo;
        return this;
    }


    public HttpMethods bulid(){
        //初始化http模块
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                try {
                    String text = URLDecoder.decode(message, "utf-8");
                    LogUtil.e( "api_msg:" + text);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)//添加Log拦截器
                .addInterceptor(new CommonInterceptor(sendBo))//注入header
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://test.gxjzgr.caihcloud.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        deviceApi = retrofit.create(DeviceApi.class);
        return this;
    }

    public HttpMethods() {

    }

    public DeviceApi getHttpApi() {
        return deviceApi;
    }




    /**
     * 设置订阅 和 所在的线程环境
     */
    public <T> void toSubscribe(Observable<T> o, DisposableObserver<T> s) {

        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retry(RETRY_COUNT)//请求失败重连次数
                .subscribe(s);

    }



}
