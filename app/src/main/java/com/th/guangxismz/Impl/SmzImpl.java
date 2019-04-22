package com.th.guangxismz.Impl;

import com.th.guangxismz.Bean.AttendanceBo;
import com.th.guangxismz.Bean.EmployeeBo;
import com.th.guangxismz.http.rxApiCallBack;

import java.util.List;

public interface SmzImpl<T> {

    void signIn(rxApiCallBack<T> rxApiCallBack);
    void keepalive(rxApiCallBack<T> rxApiCallBack);
    void listhash(rxApiCallBack<T> rxApiCallBack);
    void queryEmployeeList(rxApiCallBack<T> rxApiCallBack);
    void uploadAttendance(List<AttendanceBo> bolist, rxApiCallBack<T> rxApiCallBack);
    void queryEmployeeInfo(List<EmployeeBo> employeeBoList,rxApiCallBack<T> rxApiCallBack);
    void queryEmployeeIdInfo(String EmpId,rxApiCallBack<T> rxApiCallBack);
}
