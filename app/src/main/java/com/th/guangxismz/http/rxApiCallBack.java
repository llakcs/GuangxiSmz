package com.th.guangxismz.http;


import com.th.guangxismz.Bean.JsonResult;

import java.net.ConnectException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

public abstract  class rxApiCallBack<T> extends DisposableObserver<T> {
    public rxApiCallBack() {
    }

    @Override
    public void onNext(T t) {
        JsonResult jsonResult = (JsonResult) t;
        try {
            if(jsonResult == null){
                this.fail(-1, "服务器执行错误，请重试");
            } else if(jsonResult.getResult().equals("true")) {
                this.success((T)jsonResult.getResult_data());
            }
            else{
                this.fail(Integer.parseInt(jsonResult.getCode()), jsonResult.getMessage());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onError(Throwable e) {
        try {
            if (e instanceof ConnectException) {
                this.fail(-2, "网络错误，请检查本地网络");
            }else if (e instanceof HttpException) {//请求的地址不存在
                int code = ((HttpException) e).code();
                if (code == 504) {
                    //                    ToastManager.showShortToast("网络异常，请检查您的网络状态");
                    this.fail(-8,"网络异常，请检查您的网络状态");
                } else if (code == 404) {
                    this.fail(-5, "###请求的地址不存在");
                } else {
                    this.fail(-3, e.getMessage());
                }
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }

    @Override
    public void onComplete() {

    }
    public abstract void success(T var1);

    public abstract void fail(int var1, String var2);
}
