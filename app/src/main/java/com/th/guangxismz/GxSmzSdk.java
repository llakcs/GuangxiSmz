package com.th.guangxismz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import com.google.common.collect.Lists;
import com.th.guangxismz.Bean.EmployeeBo;
import com.th.guangxismz.Bean.EmployeeIdInfoResult;
import com.th.guangxismz.Bean.EmployeeInfoResult;
import com.th.guangxismz.Bean.Employee;
import com.th.guangxismz.Bean.EmployeeListBean;
import com.th.guangxismz.Bean.GeneralResult;
import com.th.guangxismz.Bean.HashResult;
import com.th.guangxismz.Bean.employeeResult;
import com.th.guangxismz.Impl.GxSmzSdkListner;
import com.th.guangxismz.Impl.SmzSdkImpl;
import com.th.guangxismz.config.SmzConfig;
import com.th.guangxismz.http.rxApiCallBack;
import com.th.guangxismz.utils.DPDB;
import com.th.guangxismz.utils.LogUtil;
import com.th.guangxismz.utils.RxScheduler;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;


public class GxSmzSdk implements SmzSdkImpl {
    // Minimum time is Nov 5, 2007, 0:00.
    private static final long MIN_DATE = 1194220800000L;
    private static final int NUM = 10;
    private GxSmzSdkListner mGxSmzSdkListner;
    private WeakReference<Context> mContext;
    private static  class  RxHoler{
        private static final GxSmzSdk instance = new GxSmzSdk();
    }
    public static GxSmzSdk getInstance(){
        return RxHoler.instance;
    }


    private Runnable heartBeatRunnable = new Runnable() {
        @Override
        public void run() {
            heartBeat();
        }
    };

    private Runnable listHashRunnable = new Runnable() {
        @Override
        public void run() {
            queryListHash();
        }
    };

//    private Runnable employeeListRunnable = new Runnable() {
//        @Override
//        public void run() {
//            queryEmployeeList();
//        }
//    };




    @Override
    public GxSmzSdk InitSdk(Context context) {
        mContext = new WeakReference<Context>(context);
        DPDB.InitDPDbRW(mContext.get());
        DbManger.getInstance().Init(mContext.get());
        return this;
    }

    @Override
    public GxSmzSdk config(String ApiKey, String ClientSerial, String ApiSecret) {
        //初始化配置
        SmzConfig.getInstance().Init(ApiKey,ClientSerial,ApiSecret);
        return this;
    }

    @Override
    public void build() {
        //签到
        login();
    }

    @Override
    public void setGxSmzSdkListner(GxSmzSdkListner gxSmzSdkListner) {
        this.mGxSmzSdkListner = gxSmzSdkListner;
    }

    private void login(){
        GXSmzManger.getInstance().signIn(new rxApiCallBack<GeneralResult>() {
            @Override
            public void success(GeneralResult var1) {
                LogUtil.e("签到成功");
                //同步平台时间
//                synchTime(var1.getServer_timestamp());
                //发送心跳
                heartBeat();
                //同步平台项目信息
                synchProjectInfo(var1.getProject_info().getProject_name());

            }

            @Override
            public void fail(int var1, String var2) {
                LogUtil.e("签到失败 errcode ="+var1+" //errmsg ="+var2);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                       login();
                    }
                },600*1000);
            }
        });
    }

    //心跳
    private  void  heartBeat(){
        GXSmzManger.getInstance().keepalive(new rxApiCallBack<GeneralResult>() {
            @Override
            public void success(GeneralResult var1) {
                new Handler().postDelayed(heartBeatRunnable,60*100*1000);
            }

            @Override
            public void fail(int var1, String var2) {
                new Handler().postDelayed(heartBeatRunnable,60*10*1000);
            }
        });
    }



    //同步平台时间
//    private void synchTime(String time,int hourOfDay, int minute){
//        Calendar c = Calendar.getInstance();
//
//        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
//        c.set(Calendar.MINUTE, minute);
//        c.set(Calendar.SECOND, 0);
//        c.set(Calendar.MILLISECOND, 0);
//        long when = Math.max(c.getTimeInMillis(), MIN_DATE);
//
//        if (when / 1000 < Integer.MAX_VALUE) {
//            ((AlarmManager) mContext.get().getSystemService(Context.ALARM_SERVICE)).setTime(when);
//        }
//    }




    //同步项目信息
    private void synchProjectInfo(String project_name){
        LogUtil.e("项目名称: "+project_name);
        if(TextUtils.isEmpty(project_name)){
           return;
        }
        if(TextUtils.isEmpty(DPDB.getProjectName()) || !DPDB.getProjectName().equals(project_name)){
             DPDB.setProjectName(project_name);
             //拉取所有人员信息,清空原有项目信息
            LogUtil.e("拉取所有人员信息,清空原有项目信息: "+project_name);
            DbManger.getInstance().cleanEmployeeAll();
            DbManger.getInstance().cleanEmployeeListBeanAll();
            //删除全部百度库人脸数据
            if(mGxSmzSdkListner != null){
                mGxSmzSdkListner.cleanAllFace();
            }
//            queryEmployeeList();
        }
            //发送散列
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    queryListHash();
                }
            },3000);

    }
    //发送人员散列
    private void queryListHash(){
        GXSmzManger.getInstance().listhash(new rxApiCallBack<HashResult>() {
            @Override
            public void success(HashResult var1) {
                LogUtil.e("####发送人员散列Emp_count :"+var1.getEmp_count()+" //var1.getSha1()"+var1.getSha1());

                if(DbManger.getInstance().queryEmloyeeList() != null || DbManger.getInstance().queryEmloyeeList().size() != var1.getEmp_count()){
                    //对比人员信息
                    GXSmzManger.getInstance().queryEmployeeList(new rxApiCallBack<employeeResult>() {
                        @Override
                        public void success(employeeResult var1) {
                            List<EmployeeBo> updatelist = comparedata(DbManger.getInstance().queryEmloyeeList(),var1.getEmployee_list());
                            if(updatelist != null && updatelist.size() != 0){
                                //请求需要更新人员列表详细信息
                                queryEmployeeInfo(updatelist);
                            }
                        }

                        @Override
                        public void fail(int var1, String var2) {

                        }
                    });
                }
                new Handler().postDelayed(listHashRunnable,5*60*1000);
            }

            @Override
            public void fail(int var1, String var2) {
                new Handler().postDelayed(listHashRunnable,30*1000);
            }
        });
    }


    private  List<EmployeeBo> comparedata(List<Employee> localdata,List<Employee> remotedata){

        if(localdata == null || remotedata == null){
            return null;
        }
        List<EmployeeBo> updatelist = new ArrayList<>();
        //本地与服务器数据对比
        for(Employee ldata:localdata){
            if(!remotedata.contains(ldata)){
                //删除本地employee数据
                DbManger.getInstance().deleteEmployee(ldata);
                //删除EmployeeListBean表数据
                List<EmployeeListBean> listBeans = DbManger.getInstance().queryEmployeelistBeanbyId(ldata.getEmp_id());
                for(EmployeeListBean bean : listBeans){
                    DbManger.getInstance().deleteEmployeeList(bean);
                }
                //删除百度数据库
                if(mGxSmzSdkListner != null){
                    mGxSmzSdkListner.deleteBaiduFace(ldata.getEmp_id());
                }
            }
        }
        //服务器数据与本地对比
        for(Employee rdata:remotedata){
             if(!localdata.contains(rdata)){
                 //添加服务器数据到本地
                 DbManger.getInstance().addEmployee(rdata);
                 //添加到更新列表
                 EmployeeBo employeeBo = new EmployeeBo();
                 employeeBo.setEmpId(rdata.getEmp_id());
                 updatelist.add(employeeBo);
             }

        }
        return updatelist;
    }




    //获取人员列表
//    private void queryEmployeeList(){
//        LogUtil.e("###queryEmployeeList");
//        GXSmzManger.getInstance().queryEmployeeList(new rxApiCallBack<employeeResult>() {
//            @Override
//            public void success(employeeResult var1) {
//                LogUtil.e("###queryEmployeeList.success");
//                List<EmployeeBo> boList = new ArrayList<>();
//               for(Employee info:var1.getEmployee_list()){
//                   LogUtil.e("###queryEmployeeList.info.id ="+info.getEmp_id() +"  ---  time ="+info.getModify_time());
//                   DbManger.getInstance().addEmployee(info);
//                   EmployeeBo bo = new EmployeeBo();
//                   bo.setEmpId(info.getEmp_id());
//                   boList.add(bo);
//               }
//                LogUtil.e("###queryEmployeeInfo");
//               queryEmployeeInfo(boList);
//            }
//
//            @Override
//            public void fail(int var1, String var2) {
//                LogUtil.e("###queryEmployeeList fail");
//                new Handler().postDelayed(employeeListRunnable,10*60*1000);
//            }
//        });
//    }


    //获取人员信息
    private void queryEmployeeInfo( List<EmployeeBo> employeeBoList){
        if(employeeBoList == null){
            return;
        }
        final List<List<EmployeeBo>> emplist = Lists.partition(employeeBoList,NUM);
        if (emplist == null || emplist.size() == 0) {
            return;
        }
        RxScheduler.doOnIOThread(new RxScheduler.IOTask<Void>() {
            @Override
            public void doOnIOThread() {

                for(List<EmployeeBo> bo:emplist){
                    handlerbo(bo);
                    try{
                        Thread.sleep(3000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void handlerbo(List<EmployeeBo> boList){
        GXSmzManger.getInstance().queryEmployeeInfo(boList,new rxApiCallBack<EmployeeInfoResult>() {
            @Override
            public void success(EmployeeInfoResult var1) {
                LogUtil.d("####handlerbo.size ="+var1.getEmployee_list().size());
                Register(var1.getEmployee_list());
            }

            @Override
            public void fail(int var1, String var2) {
            }
        });
    }

    /**
     * base64转为bitmap
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }


    //注册人脸
    private void Register(final List<EmployeeListBean> listBeans){
        RxScheduler.doOnIOThread(new RxScheduler.IOTask<Void>() {
            @Override
            public void doOnIOThread() {
                for(EmployeeListBean employeeListBean:listBeans){
                    LogUtil.d("##服务器下载成功 用户id ="+employeeListBean.getEmp_id()+" 用户姓名="+employeeListBean.getEmp_name());
                    DbManger.getInstance().addEmployeeList(employeeListBean);
                    if(mGxSmzSdkListner != null){
                        String facephoto=employeeListBean.getFacephoto();
                        if(!TextUtils.isEmpty(facephoto)){
                            Bitmap bitmap = base64ToBitmap(facephoto);
                            try {
                                Thread.sleep(100);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            if(bitmap !=null){
                                mGxSmzSdkListner.faceRegister(bitmap,employeeListBean.getEmp_id());
                            }
                        }else{
                            LogUtil.e("###用户id ="+employeeListBean.getEmp_id()+" 用户名:"+employeeListBean.getEmp_name()+"没有照片");
                        }

                    }
                }
            }
        });
    }





    //根据ID来找寻人员信息
    private void  queryEmployeeIdInfo(String id){
        GXSmzManger.getInstance().queryEmployeeIdInfo(id, new rxApiCallBack<EmployeeIdInfoResult>() {
            @Override
            public void success(EmployeeIdInfoResult var1) {

            }

            @Override
            public void fail(int var1, String var2) {

            }
        });
    }
    //上传考勤记录
    private void uploadAttendance(String Direction, String Person_id, String Person_name, String Person_type, String Site_photo, String way){
        GXSmzManger.getInstance().uploadPassedLog(Direction, Person_id, Person_name, Person_type, Site_photo, way, new rxApiCallBack() {
            @Override
            public void success(Object var1) {

            }

            @Override
            public void fail(int var1, String var2) {

            }
        });
    }




}
