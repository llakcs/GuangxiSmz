package com.th.guangxismz.http;

import com.th.guangxismz.Bean.CommonSendBo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CommonInterceptor implements Interceptor {

    private CommonSendBo sendBo;
    public CommonInterceptor(CommonSendBo commonSendBo) {
        this.sendBo = commonSendBo;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        String time =simpleDateFormat.format(date);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();

        // 添加新的参数
        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host())
                .addQueryParameter("api_key", this.sendBo.getApiKey())
                .addQueryParameter("api_version", this.sendBo.getApiVersion())
                .addQueryParameter("client_serial", this.sendBo.getClientSerial())
                .addQueryParameter("timestamp", this.sendBo.getTimestamp())
                .addQueryParameter("signature", this.sendBo.getSignature());

        // 新的请求
        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newRequest);
    }
}