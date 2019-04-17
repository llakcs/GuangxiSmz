package com.th.guangxismz.Bean;

public class JsonResult<T> {
    /**
     * result : true
     * status : 200
     * code : 00
     * message : success
     * detail_message : 成功
     * result_data : {"employee_list":[{"emp_id":"A38B9EC7C7A9404DB12ED8AB2C031207","id_photo":""}]}
     */

    private String result;
    private int status;
    private String code;
    private String message;
    private String detail_message;
    private T result_data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail_message() {
        return detail_message;
    }

    public void setDetail_message(String detail_message) {
        this.detail_message = detail_message;
    }

    public T getResult_data() {
        return result_data;
    }

    public void setResult_data(T result_data) {
        this.result_data = result_data;
    }
}
