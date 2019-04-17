package com.th.guangxismz.http;


import com.th.guangxismz.Bean.CommonSendBo;

import io.reactivex.Observable;
import okhttp3.RequestBody;


public class RxHttp<T> {
    private static  class  RxHoler{
        private static final RxHttp instance = new RxHttp();
    }
    public static RxHttp getInstance(){
        return RxHoler.instance;
    }


    public void signIn(RequestBody requestBody, CommonSendBo sendBo, rxApiCallBack<T> rxApiCallBack){
        Observable<T> observable =  HttpMethods.getInstance().setSendBo(sendBo).bulid().getHttpApi().signIn(requestBody);
        HttpMethods.getInstance().toSubscribe(observable, rxApiCallBack);
    }

    public void keepalive(RequestBody requestBody, CommonSendBo sendBo, rxApiCallBack<T> rxApiCallBack){
        Observable<T> observable =  HttpMethods.getInstance().setSendBo(sendBo).bulid().getHttpApi().KeepAlive(requestBody);
        HttpMethods.getInstance().toSubscribe(observable, rxApiCallBack);
    }

    public void listhash(RequestBody requestBody, CommonSendBo sendBo, rxApiCallBack<T> rxApiCallBack){
        Observable<T> observable =  HttpMethods.getInstance().setSendBo(sendBo).bulid().getHttpApi().queryEmpListHash(requestBody);
        HttpMethods.getInstance().toSubscribe(observable, rxApiCallBack);
    }

    public void queryEmployeeList(RequestBody requestBody, CommonSendBo sendBo, rxApiCallBack<T> rxApiCallBack){
        Observable<T> observable =  HttpMethods.getInstance().setSendBo(sendBo).bulid().getHttpApi().queryEmployeeList(requestBody);
        HttpMethods.getInstance().toSubscribe(observable, rxApiCallBack);
    }
    public void uploadPassedLog(RequestBody requestBody, CommonSendBo sendBo, rxApiCallBack<T> rxApiCallBack){
        Observable<T> observable =  HttpMethods.getInstance().setSendBo(sendBo).bulid().getHttpApi().uploadPassedLog(requestBody);
        HttpMethods.getInstance().toSubscribe(observable, rxApiCallBack);
    }

    public void queryEmployeeInfo(RequestBody requestBody, CommonSendBo sendBo, rxApiCallBack<T> rxApiCallBack){
        Observable<T> observable =  HttpMethods.getInstance().setSendBo(sendBo).bulid().getHttpApi().queryEmployeeInfo(requestBody);
        HttpMethods.getInstance().toSubscribe(observable, rxApiCallBack);
    }

    public void queryEmployeeIdInfo(RequestBody requestBody, CommonSendBo sendBo, rxApiCallBack<T> rxApiCallBack){
        Observable<T> observable =  HttpMethods.getInstance().setSendBo(sendBo).bulid().getHttpApi().queryEmployeeIdInfo(requestBody);
        HttpMethods.getInstance().toSubscribe(observable, rxApiCallBack);
    }
}
