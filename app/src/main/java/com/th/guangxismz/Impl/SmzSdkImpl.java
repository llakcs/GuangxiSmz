package com.th.guangxismz.Impl;

import android.content.Context;

import com.th.guangxismz.Bean.EmployeeListBean;
import com.th.guangxismz.GxSmzSdk;

import java.util.List;

public interface SmzSdkImpl {
    GxSmzSdk InitSdk(Context context);
    GxSmzSdk config(String ApiKey, String ClientSerial, String ApiSecret);
    void build();
    GxSmzSdk setGxSmzSdkListner(GxSmzSdkListner gxSmzSdkListner);
    EmployeeListBean queryImageForId(String empId);

}
