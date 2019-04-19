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
    void addEmployeeList(EmployeeListBean bean);
    void deleteEmployeeList(EmployeeListBean bean);
    void uploadAttendance(String Direction, String Person_id, String Person_name, String Person_type, String Site_photo, String way);

}
