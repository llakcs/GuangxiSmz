package com.th.guangxismz.utils;

import android.util.Log;

/**
 * Created by jelly on 2017/9/20.
 */

public class LogUtil {
    public static final int VERBOSE = 0;
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int WARN = 3;
    public static final int ERROR = 4;
    public static final int NONE = 5;

    private static int level = VERBOSE;
    private static String TAG="GuangxiSmz";
    public static void setLevel(int level) {
        LogUtil.level = level;
    }
    public static  void setTAG(String tag){
        TAG = tag;
    }
    public static void v(String msg){
        if(msg==null) {
            Log.e(TAG,"v msg == null");
            return;
        }
        if(level<=VERBOSE){
            int max_str_length = 2001 - TAG.length();
            //大于4000时
            while (msg.length() > max_str_length) {
                Log.v(TAG, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            Log.v(TAG, msg);
        }
    }
    public static void d(String msg){
        if(msg==null) {
            Log.e(TAG,"d msg == null");
            return;
        }
        if(level<=DEBUG){
            int max_str_length = 2001 - TAG.length();
            //大于4000时
            while (msg.length() > max_str_length) {
                Log.d(TAG, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            Log.d(TAG, msg);
        }
    }
    public static void i(String msg){
        if(msg==null)  {
            Log.e(TAG,"i msg == null");
            return;
        }
        if(level<=INFO) {
            int max_str_length = 2001 - TAG.length();
            //大于4000时
            while (msg.length() > max_str_length) {
                Log.i(TAG, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            Log.i(TAG, msg);
        }
    }
    public static void w(String msg){
        if(msg==null)  {
            Log.e(TAG,"w msg == null");
            return;
        }
        if(level<=WARN){
            int max_str_length = 2001 - TAG.length();
            //大于4000时
            while (msg.length() > max_str_length) {
                Log.w(TAG, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            Log.w(TAG, msg);
        }
    }
    public static void e(String msg){
        if(msg==null)  {
            Log.e(TAG,"e msg == null");
            return;
        }
        if(level<=ERROR){
            int max_str_length = 2001 - TAG.length();
            //大于4000时
            while (msg.length() > max_str_length) {
                Log.e(TAG, msg.substring(0, max_str_length));
                msg = msg.substring(max_str_length);
            }
            Log.e(TAG, msg);
        }
    }
    public static void e(String msg, Exception e){
        if(msg==null) {
            Log.e(TAG,"e msg == null");
            return;
        }
        if(level<=ERROR){
            int max_str_length = 2001 - TAG.length();
            //大于4000时
            while (msg.length() > max_str_length) {
                Log.e(TAG, msg.substring(0, max_str_length),e);
                msg = msg.substring(max_str_length);
            }
            Log.e(TAG, msg,e);
        }
    }


}
