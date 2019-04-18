package com.th.guangxismz.Impl;

import android.graphics.Bitmap;

import com.th.guangxismz.Bean.Employee;

import java.util.List;

public interface GxSmzSdkListner {

    void deleteBaiduFace(String empId);
    void faceRegister(Bitmap bitmap,String empId);
    void cleanAllFace(List<Employee> employees);
    void loadFacesFromDB();
    void projectInfo(int pNumber);
}
