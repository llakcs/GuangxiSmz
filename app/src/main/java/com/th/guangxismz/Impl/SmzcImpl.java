package com.th.guangxismz.Impl;

import com.th.guangxismz.Bean.AttendanceBo;
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
    CommonSendBo uploadAttendance(List<AttendanceBo> attendanceBoGroup);
    CommonSendBo queryEmployeeInfo(List<EmployeeBo> employeeBoList);
    CommonSendBo queryEmployeeIdInfo(String EmpId);

}
