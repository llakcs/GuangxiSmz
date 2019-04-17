package com.th.guangxismz.Bean;

public class GeneralResult {

    /**
     * server_timestamp : 2019-03-28 16:59:47
     * emp_syncflag : Y
     * project_info : {"project_name":"售后管理工程","project_manager":null,"project_brief":null,"project_address":"广西壮族自治区南宁市良庆区平乐大道18号","company_name":null,"work_typename":null}
     * newversion_list : null
     */

    private String server_timestamp;
    private String emp_syncflag;
    private ProjectInfoBean project_info;
    private Object newversion_list;

    public String getServer_timestamp() {
        return server_timestamp;
    }

    public void setServer_timestamp(String server_timestamp) {
        this.server_timestamp = server_timestamp;
    }

    public String getEmp_syncflag() {
        return emp_syncflag;
    }

    public void setEmp_syncflag(String emp_syncflag) {
        this.emp_syncflag = emp_syncflag;
    }

    public ProjectInfoBean getProject_info() {
        return project_info;
    }

    public void setProject_info(ProjectInfoBean project_info) {
        this.project_info = project_info;
    }

    public Object getNewversion_list() {
        return newversion_list;
    }

    public void setNewversion_list(Object newversion_list) {
        this.newversion_list = newversion_list;
    }
}
