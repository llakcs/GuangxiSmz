package com.th.guangxismz.http;



import com.th.guangxismz.Bean.EmployeeIdInfoResult;
import com.th.guangxismz.Bean.EmployeeInfoResult;
import com.th.guangxismz.Bean.HashResult;
import com.th.guangxismz.Bean.JsonResult;
import com.th.guangxismz.Bean.GeneralResult;
import com.th.guangxismz.Bean.employeeResult;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DeviceApi<T> {


    /**
     *更新下载接口
     */
//    @Streaming
////    @FormUrlEncoded
////    @POST("/api/downloadApk")
////    Observable<ResponseBody> download(@Field("token") String token, @Field("timeStamp") String timeStamp, @Field("random") String random);
////
////    @FormUrlEncoded
////    @POST("/api/deviceUpdate")
////    Observable<JsonResult<data>> getUpdateTag(@Field("token") String token, @Field("timeStamp") String timeStamp, @Field("random") String random);


    @POST("CWRService/Signin")
    Observable<JsonResult<GeneralResult>> signIn(@Body RequestBody requestBody);

    @POST("CWRService/KeepAlive")
    Observable<JsonResult<GeneralResult>> KeepAlive(@Body RequestBody requestBody);
//
    @POST("CWRService/QueryEmployeeList")
    Observable<JsonResult<employeeResult>> queryEmployeeList(@Body RequestBody requestBody);

    @POST("CWRService/QueryEmployeeInfo")
    Observable<JsonResult<EmployeeInfoResult>> queryEmployeeInfo(@Body RequestBody requestBody);
//
    @POST("CWRService/QueryEmployeeIdInfo")
    Observable<JsonResult<EmployeeIdInfoResult>> queryEmployeeIdInfo(@Body RequestBody requestBody);

    @POST("CWRService/QueryEmpListHash")
    Observable<JsonResult<HashResult>> queryEmpListHash(@Body RequestBody requestBody);
//
    @POST("CWRService/UploadPassedLog")
    Observable<JsonResult> uploadPassedLog(@Body RequestBody requestBody);

}
