package com.th.guangxismz.Bean;

import java.util.List;

public class EmployeeIdInfoResult {
    private List<Object> employee_list;
    private String emp_id;
    private String id_photo;

    public List<Object> getEmployee_list() {
        return employee_list;
    }

    public void setEmployee_list(List<Object> employee_list) {
        this.employee_list = employee_list;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getId_photo() {
        return id_photo;
    }

    public void setId_photo(String id_photo) {
        this.id_photo = id_photo;
    }
}
