package com.th.guangxismz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.th.guangxismz.Bean.AttendanceBo;
import com.th.guangxismz.Bean.DaoMaster;
import com.th.guangxismz.http.rxApiCallBack;
import com.th.guangxismz.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

//        sendBo.setApiKey("E26D53A4D79848E2AA9BE5EAE1F4FD43");
//        sendBo.setClientSerial("FT00000004");
//        sendBo.setApiSecret("4988678FE3C54A368F7E954D02CFF2E8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GxSmzSdk.getInstance().InitSdk(this)
                .config("E26D53A4D79848E2AA9BE5EAE1F4FD43","FT00000004","4988678FE3C54A368F7E954D02CFF2E8")
                .build();
//        ExecutorService executorServce = Executors.newFixedThreadPool(10);


//        GXSmzManger.getInstance().signIn();
//        GXSmzManger.getInstance().keepalive();
//        GXSmzManger.getInstance().listhash();
//        GXSmzManger.getInstance().queryEmployeeList(new rxApiCallBack() {
//            @Override
//            public void success(Object var1) {
//
//            }
//
//            @Override
//            public void fail(int var1, String var2) {
//
//            }
//        });
//        List<AttendanceBo> boList= new ArrayList<>();
//        AttendanceBo bo = new AttendanceBo();
//        bo.setDirection("in");
//        bo.setPerson_id("DCEA13DDFD5D4C449004F4EB85B18D59");
//        bo.setPerson_name("lee");
//        bo.setPerson_type("0");
//        bo.setPassed_time("2019-04-22");
//        bo.setSite_photo("Test");
//        bo.setWay("1");
//        AttendanceBo bo2 = new AttendanceBo();
//        bo2.setDirection("in");
//        bo2.setPerson_id("DCEA13DDFD5D4C449004F4EB85B18123");
//        bo2.setPerson_name("lee123");
//        bo2.setPerson_type("0");
//        bo2.setPassed_time("2019-04-22");
//        bo2.setSite_photo("Test");
//        bo2.setWay("1");
//        boList.add(bo);
//        boList.add(bo2);
//        GXSmzManger.getInstance().uploadAttendance(boList, new rxApiCallBack() {
//            @Override
//            public void success(Object var1) {
//
//            }
//
//            @Override
//            public void fail(int var1, String var2) {
//
//            }
//        });
//        GXSmzManger.getInstance().queryEmployeeInfo();
//        GXSmzManger.getInstance().queryEmployeeIdInfo("A38B9EC7C7A9404DB12ED8AB2C031207");
    }


}
