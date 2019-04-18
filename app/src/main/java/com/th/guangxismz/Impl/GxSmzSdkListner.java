package com.th.guangxismz.Impl;

import android.graphics.Bitmap;

import com.th.guangxismz.Bean.Employee;

import java.util.List;

public interface GxSmzSdkListner {

    void deleteBaiduFace(String empId);
    boolean faceRegister(Bitmap bitmap,String empId,String username);
    void cleanAllFace(List<Employee> employees);
    void loadFacesFromDB();
    void projectInfo(int pNumber);
    void getFlag(boolean flag);
}
