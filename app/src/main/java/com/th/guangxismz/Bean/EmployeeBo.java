package com.th.guangxismz.Bean;

import com.google.gson.annotations.SerializedName;

public class EmployeeBo {
    @SerializedName("emp_id")
    private String empId;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
