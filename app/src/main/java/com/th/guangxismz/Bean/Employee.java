/**
  * Copyright 2019 bejson.com 
  */
package com.th.guangxismz.Bean;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Auto-generated: 2019-04-12 10:22:25
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Entity
public class Employee {
    @Id(autoincrement = true)
    private Long id;
    private String emp_id;
    private String modify_time;
    @Generated(hash = 1332729323)
    public Employee(Long id, String emp_id, String modify_time) {
        this.id = id;
        this.emp_id = emp_id;
        this.modify_time = modify_time;
    }
    @Generated(hash = 202356944)
    public Employee() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmp_id() {
        return this.emp_id;
    }
    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }
    public String getModify_time() {
        return this.modify_time;
    }
    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if( obj == null){
             return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }

        Employee employee =(Employee)obj;
        if(employee.getEmp_id()  == null){
            return false;
        }
        if(emp_id == null){
            return false;
        }else if( !emp_id.equals(employee.emp_id )){
            return false;
        }
        return true;
    }
}