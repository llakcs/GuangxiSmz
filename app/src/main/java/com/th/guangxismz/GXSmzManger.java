package com.th.guangxismz;

import com.th.guangxismz.Bean.CommonSendBo;
import com.th.guangxismz.config.SmzConfig;
import com.th.guangxismz.http.RxHttp;
import com.th.guangxismz.http.rxApiCallBack;
import com.th.guangxismz.Impl.SmzImpl;

import java.util.List;

import okhttp3.RequestBody;

public class GXSmzManger implements SmzImpl {



    private static class RxHoler {
        private static final GXSmzManger instance = new GXSmzManger();
    }

    public static GXSmzManger getInstance() {
        return GXSmzManger.RxHoler.instance;
    }

    @Override
    public void signIn(rxApiCallBack rxApiCallBack) {
        CommonSendBo sendBo = SmzConfig.getInstance().SignInData();
        RequestBody requestBody = SmzConfig.getInstance().getRequestBody(sendBo);
        RxHttp.getInstance().signIn(requestBody, sendBo,rxApiCallBack);
    }

    @Override
    public void keepalive(rxApiCallBack rxApiCallBack) {
        CommonSendBo sendBo = SmzConfig.getInstance().Heartbeat();
        RequestBody requestBody= SmzConfig.getInstance().getRequestBody(sendBo);
        RxHttp.getInstance().keepalive(requestBody, sendBo,rxApiCallBack);
    }

    @Override
    public void listhash(rxApiCallBack rxApiCallBack) {
        CommonSendBo sendBo = SmzConfig.getInstance().queryListHash();
        RequestBody requestBody= SmzConfig.getInstance().getRequestBody(sendBo);
        RxHttp.getInstance().listhash(requestBody, sendBo,rxApiCallBack);
    }

    @Override
    public void queryEmployeeList(rxApiCallBack rxApiCallBack) {
        CommonSendBo sendBo = SmzConfig.getInstance().queryEmployeeList();
        RequestBody requestBody= SmzConfig.getInstance().getRequestBody(sendBo);
        RxHttp.getInstance().queryEmployeeList(requestBody, sendBo,rxApiCallBack);
    }

    @Override
    public void uploadPassedLog(String Direction, String Person_id, String Person_name, String Person_type, String Site_photo, String way, rxApiCallBack rxApiCallBack) {
        CommonSendBo sendBo = SmzConfig.getInstance().uploadAttendance(Direction,Person_id,Person_name,Person_type,Site_photo,way);
        RequestBody requestBody= SmzConfig.getInstance().getRequestBody(sendBo);
        RxHttp.getInstance().uploadPassedLog(requestBody, sendBo,rxApiCallBack);
    }

    @Override
    public void queryEmployeeInfo(List employeeBoList, rxApiCallBack rxApiCallBack) {
        CommonSendBo sendBo = SmzConfig.getInstance().queryEmployeeInfo(employeeBoList);
        RequestBody requestBody= SmzConfig.getInstance().getRequestBody(sendBo);
        RxHttp.getInstance().queryEmployeeInfo(requestBody, sendBo,rxApiCallBack);
    }



    @Override
    public void queryEmployeeIdInfo(String EmpId, rxApiCallBack rxApiCallBack) {
        CommonSendBo sendBo = SmzConfig.getInstance().queryEmployeeIdInfo(EmpId);
        RequestBody requestBody= SmzConfig.getInstance().getRequestBody(sendBo);
        RxHttp.getInstance().queryEmployeeIdInfo(requestBody, sendBo,rxApiCallBack);
    }

}
