package com.th.guangxismz.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class EmployeeListBean {

    @Id(autoincrement = true)
    private Long id;
    private String emp_id;
    private String emp_name;
    private String modify_time;
    private String sex;
    private String emp_age;
    private String emp_phone;
    private String facephoto;
    private String emp_company;
    private String work_typename;
    private String pass_period;
    private String emp_category;

    @Generated(hash = 553686813)
    public EmployeeListBean(Long id, String emp_id, String emp_name,
            String modify_time, String sex, String emp_age, String emp_phone,
            String facephoto, String emp_company, String work_typename,
            String pass_period, String emp_category) {
        this.id = id;
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.modify_time = modify_time;
        this.sex = sex;
        this.emp_age = emp_age;
        this.emp_phone = emp_phone;
        this.facephoto = facephoto;
        this.emp_company = emp_company;
        this.work_typename = work_typename;
        this.pass_period = pass_period;
        this.emp_category = emp_category;
    }

    @Generated(hash = 1934557242)
    public EmployeeListBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(String emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(String emp_phone) {
        this.emp_phone = emp_phone;
    }

    public String getFacephoto() {
        return facephoto;
    }

    public void setFacephoto(String facephoto) {
        this.facephoto = facephoto;
    }

    public String getEmp_company() {
        return emp_company;
    }

    public void setEmp_company(String emp_company) {
        this.emp_company = emp_company;
    }

    public String getWork_typename() {
        return work_typename;
    }

    public void setWork_typename(String work_typename) {
        this.work_typename = work_typename;
    }

    public String getPass_period() {
        return pass_period;
    }

    public void setPass_period(String pass_period) {
        this.pass_period = pass_period;
    }

    public String getEmp_category() {
        return emp_category;
    }

    public void setEmp_category(String emp_category) {
        this.emp_category = emp_category;
    }
}
