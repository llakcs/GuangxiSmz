package com.th.guangxismz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.th.guangxismz.Bean.DaoMaster;
import com.th.guangxismz.http.rxApiCallBack;
import com.th.guangxismz.utils.LogUtil;

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
//        GXSmzManger.getInstance().uploadPassedLog("out","DCEA13DDFD5D4C449004F4EB85B18D59","lee","0","Test","1");
//        GXSmzManger.getInstance().queryEmployeeInfo();
//        GXSmzManger.getInstance().queryEmployeeIdInfo("A38B9EC7C7A9404DB12ED8AB2C031207");
    }


}
