package com.th.guangxismz.Impl;

import com.th.guangxismz.Bean.CommonSendBo;
import com.th.guangxismz.Bean.EmployeeBo;

import java.util.List;

import okhttp3.RequestBody;

public interface SmzcImpl {
    void Init(String ApiKey,String ClientSerial,String ApiSecret);
    RequestBody getRequestBody(CommonSendBo sendBo);
    CommonSendBo SignInData();
    CommonSendBo MD5Data(CommonSendBo sendBo);
    CommonSendBo Heartbeat();
    CommonSendBo queryListHash();
    CommonSendBo queryEmployeeList();
    CommonSendBo uploadAttendance(String Direction,String Person_id,String Person_name,String Person_type,String Site_photo,String way);
    CommonSendBo queryEmployeeInfo(List<EmployeeBo> employeeBoList);
    CommonSendBo queryEmployeeIdInfo(String EmpId);

}
