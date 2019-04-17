package com.th.guangxismz.Impl;

import android.graphics.Bitmap;

public interface GxSmzSdkListner {

    void deleteBaiduFace(String empId);
    void faceRegister(Bitmap bitmap,String empId);
    void cleanAllFace();
}
