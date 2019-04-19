package com.th.guangxismz.Impl;

import android.graphics.Bitmap;

import com.th.guangxismz.Bean.Employee;
import com.th.guangxismz.Bean.EmployeeListBean;

import java.util.List;

public interface GxSmzSdkListner {

    void deleteBaiduFace(String empId);
    void faceRegister(Bitmap bitmap, EmployeeListBean bean);
    void cleanAllFace(List<Employee> employees);
    void loadFacesFromDB();
    void projectCount(int pNumber);
    void projectName(String projectName);
}
