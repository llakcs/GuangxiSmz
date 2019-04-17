package com.th.guangxismz.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.th.guangxismz.Bean.AttendanceBo;
import com.th.guangxismz.Bean.CommonSendBo;
import com.th.guangxismz.Bean.EmployeeBo;
import com.th.guangxismz.Impl.SmzcImpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class SmzConfig implements SmzcImpl {
    private static MessageDigest MD5;
    private static Gson GSON = new GsonBuilder().create();
    static {
        try {
            MD5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private String mApiKey;
    private String mClientSerial;
    private String mApiSecret;

    private static class RxHoler {
        private static final SmzConfig instance = new SmzConfig();
    }

    public static SmzConfig getInstance() {
        return SmzConfig.RxHoler.instance;
    }

    @Override
    public void Init(String ApiKey, String ClientSerial, String ApiSecret) {
        this.mApiKey = ApiKey;
        this.mClientSerial = ClientSerial;
        this.mApiSecret = ApiSecret;
    }

    @Override
    public RequestBody getRequestBody(CommonSendBo sendBo) {
        return RequestBody.create(MediaType.parse("application/json"), sendBo.getData());
    }

    @Override
    public CommonSendBo MD5Data(CommonSendBo sendBo) {
        sendBo.setSignature(generateSignature(sendBo));
        return  sendBo;
    }

    //签到数据
    @Override
    public CommonSendBo  SignInData(){
        CommonSendBo sendBo = new CommonSendBo();
        commonData(sendBo);
//        1. 登录
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("current_version", "0.01");
        hashMap.put("version_type", "main");
        getSignInData(sendBo, hashMap);
        return  MD5Data(sendBo);
    }

    //心跳数据
    @Override
    public CommonSendBo Heartbeat() {
        CommonSendBo sendBo = new CommonSendBo();
        commonData(sendBo);
        keepAlive(sendBo);
        return MD5Data(sendBo);
    }
    //散列
    @Override
    public CommonSendBo queryListHash() {
        CommonSendBo sendBo = new CommonSendBo();
        commonData(sendBo);
        queryListHash(sendBo);
        return MD5Data(sendBo);
    }

    @Override
    public CommonSendBo queryEmployeeList() {
        CommonSendBo sendBo = new CommonSendBo();
        commonData(sendBo);
       // 4. 获取人员名单
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("emp_company", "");
        hashMap.put("emp_name", "");
        hashMap.put("emp_phone","");
        hashMap.put("id_code","");
        queryEmployeeList(sendBo, hashMap);
        return MD5Data(sendBo);
    }

    @Override
    public CommonSendBo uploadAttendance(String Direction, String Person_id, String Person_name, String Person_type, String Site_photo, String way) {
        CommonSendBo sendBo = new CommonSendBo();
        commonData(sendBo);
        // 7. 上传考勤记录
        AttendanceBo attendanceBo = new AttendanceBo();
        List<AttendanceBo> attendanceBoGroup = new ArrayList<>();
        attendanceBoGroup.add(attendanceBo);
        attendanceBo.setDirection(Direction);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String now = simpleDateFormat.format(date);
        attendanceBo.setPassed_time(now);
        attendanceBo.setPerson_id(Person_id);
        attendanceBo.setPerson_name(Person_name);
        attendanceBo.setPerson_type(Person_type);
        attendanceBo.setSite_photo(Site_photo);
        attendanceBo.setWay(way);
        uploadAttendance(sendBo, attendanceBoGroup);
        return MD5Data(sendBo);
    }


    @Override
    public CommonSendBo queryEmployeeInfo(List<EmployeeBo> employeeBoList) {
        CommonSendBo sendBo = new CommonSendBo();
        commonData(sendBo);
        queryEmployeeInfo(sendBo,employeeBoList);
        return MD5Data(sendBo);
    }

    @Override
    public CommonSendBo queryEmployeeIdInfo(String EmpId) {
        CommonSendBo sendBo = new CommonSendBo();
        commonData(sendBo);
        // 6. 获取指定人员身份
        EmployeeBo employeeBo = new EmployeeBo();
        employeeBo.setEmpId(EmpId);
        queryEmployeeIdentity(sendBo, employeeBo);
        return MD5Data(sendBo);
    }

    /**
     * 获取人员身份信息
     *
     * @param sendBo
     * @param employeeBo
     */
    private void queryEmployeeIdentity(CommonSendBo sendBo, EmployeeBo employeeBo) {
        List<EmployeeBo> employeeBoList = new ArrayList<>();
        employeeBoList.add(employeeBo);
        HashMap h = new HashMap();
        h.put("employee_list", employeeBoList);
        String jsonStr = GSON.toJson(h);
        sendBo.setData(jsonStr);
    }


    /**
     * 获取人员信息
     *
     * @param sendBo
     */
    private void queryEmployeeInfo(CommonSendBo sendBo,List<EmployeeBo> employeeBoList) {
//        EmployeeBo employeeBo = new EmployeeBo();
//        List<EmployeeBo> employeeBoList = new ArrayList<>();
//
//        employeeBo.setEmpId("09C2F5A3C1864B1C96385D406E31018B");
//        employeeBoList.add(employeeBo);

        HashMap h = new HashMap();
        h.put("employee_list", employeeBoList);
        h.put("facephoto_mode", "byte");

        String jsonStr = GSON.toJson(h);
        sendBo.setData(jsonStr);
    }




    /**
     * 上传考勤记录
     *
     * @param sendBo
     * @param attendanceBoGroup
     */
    private  void uploadAttendance(CommonSendBo sendBo, List<AttendanceBo> attendanceBoGroup) {
        String jsonStr = GSON.toJson(attendanceBoGroup);
        sendBo.setData(jsonStr);
    }


    /**
     * 获取人员列表
     *
     * @param sendBo
     */
    private  void queryEmployeeList(CommonSendBo sendBo, HashMap hashMap) {
        String body = GSON.toJson(hashMap);

        sendBo.setData(body);
    }



    /**
     * 心跳
     *
     * @param sendBo
     */
    private void keepAlive(CommonSendBo sendBo) {
        String body = GSON.toJson(new HashMap<>());
        sendBo.setData(body);
    }

    /**
     * 获取人员名单散列值
     *
     * @param sendBo
     */
    private void queryListHash(CommonSendBo sendBo) {
        String body = GSON.toJson(new HashMap<>());
        sendBo.setData(body);
    }



    /**
     * 登录
     *
     * @param sendBo
     */
    private  void getSignInData(CommonSendBo sendBo, HashMap hashMap) {
        List<HashMap> list = new ArrayList<>();
        list.add(hashMap);
        HashMap<String, List> resHash = new HashMap<>();
        resHash.put("version_list", list);
        String body = GSON.toJson(resHash);
        sendBo.setData(body);
    }


    private  String generateSignature(CommonSendBo sendBo) {
        String sendBoStr = sendBo.toString();
        System.out.println(sendBoStr);
        MD5.update(sendBoStr.getBytes(StandardCharsets.UTF_8));
        byte[] b = MD5.digest();
        int i;
        StringBuilder buf = new StringBuilder("");
        for (byte b1 : b) {
            i = b1;
            if (i < 0) {
                i += 256;
            }
            if (i < 16) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(i));
        }

        return buf.toString().toUpperCase();
    }

    private void commonData(CommonSendBo sendBo) {
        sendBo.setApiKey(mApiKey);
        sendBo.setClientSerial(mClientSerial);
        sendBo.setApiSecret(mApiSecret);
        sendBo.setApiVersion("1.0");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        sendBo.setTimestamp(simpleDateFormat.format(date));
//        String now = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());

    }
}
