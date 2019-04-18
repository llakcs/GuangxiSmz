package com.th.guangxismz.Impl;

import android.content.Context;

import com.th.guangxismz.GxSmzSdk;

public interface SmzSdkImpl {
    GxSmzSdk InitSdk(Context context);
    GxSmzSdk config(String ApiKey, String ClientSerial, String ApiSecret);
    void build();
    GxSmzSdk setGxSmzSdkListner(GxSmzSdkListner gxSmzSdkListner);
}
