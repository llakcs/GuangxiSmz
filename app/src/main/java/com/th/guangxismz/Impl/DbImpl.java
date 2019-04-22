package com.th.guangxismz.Impl;

import android.content.Context;

import com.th.guangxismz.Bean.AttendanceBo;
import com.th.guangxismz.Bean.Employee;
import com.th.guangxismz.Bean.EmployeeListBean;

import java.util.List;

public interface DbImpl {
    void Init(Context context);
    void addEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void updatEmployee(Employee employee);
    void cleanEmployeeAll();
    List<Employee>  queryEmloyeeListbyId(String id);
    List<Employee> queryEmloyeeList();
    void addEmployeeList(EmployeeListBean bean);
    void deleteEmployeeList(EmployeeListBean bean);
    void updateEmployeeListBean(EmployeeListBean bean);
    void cleanEmployeeListBeanAll();
    List<EmployeeListBean> queryEmployeelistBeanbyId(String empid);
    List<EmployeeListBean> queryEmployeeListBeanAll();
    void addAttendanceBo(AttendanceBo attendanceBo);
    void deleteAttendanceBo(AttendanceBo attendanceBo);
    void updatAttendanceBo(AttendanceBo attendanceBo);
    void cleanAttendanceBoAll();
    List<AttendanceBo> queryAttendanceBoList();

}
