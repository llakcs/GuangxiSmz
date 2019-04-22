package com.th.guangxismz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.th.guangxismz.Bean.AttendanceBo;
import com.th.guangxismz.Bean.DaoMaster;
import com.th.guangxismz.Bean.DaoSession;
import com.th.guangxismz.Bean.Employee;
import com.th.guangxismz.Bean.EmployeeDao;
import com.th.guangxismz.Bean.EmployeeListBean;
import com.th.guangxismz.Bean.EmployeeListBeanDao;
import com.th.guangxismz.Impl.DbImpl;

import org.greenrobot.greendao.query.QueryBuilder;

import java.lang.ref.WeakReference;
import java.util.List;

public class DbManger implements DbImpl {
    private SQLiteDatabase db;
    private DaoMaster.DevOpenHelper mHelper;
    private DaoMaster mDaoReadMaster;
    private DaoMaster mDaoWriteMaster;
    private DaoSession mDaoRSession;
    private DaoSession mDaoWSession;
    private WeakReference<Context> mContext;
    private volatile static DbManger mSingleton = null;
    public static DbManger getInstance() {
        if (mSingleton == null) {
            synchronized (DbManger.class) {
                if (mSingleton == null) {
                    mSingleton = new DbManger();
                }
            }
        }
        return mSingleton;

    }

    private SQLiteDatabase getReadableDatabase(){
        return mHelper.getReadableDatabase();
    }

    private SQLiteDatabase getWritableDatabase(){
        return mHelper.getWritableDatabase();
    }


    @Override
    public void Init(Context context) {
        mContext = new WeakReference<Context>(context);
        mHelper = new DaoMaster.DevOpenHelper(mContext.get(),"gxsmz-db",null);
        mDaoReadMaster = new DaoMaster(getReadableDatabase());
        mDaoWriteMaster = new DaoMaster(getWritableDatabase());
        mDaoRSession = mDaoReadMaster.newSession();
        mDaoWSession = mDaoWriteMaster.newSession();
    }
    //人员名单表操作如下
    @Override
    public void addEmployee(Employee employee) {
        mDaoWSession.getEmployeeDao().insert(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        mDaoWSession.getEmployeeDao().delete(employee);
    }

    @Override
    public void updatEmployee(Employee employee) {
        mDaoWSession.getEmployeeDao().update(employee);
    }

    @Override
    public  List<Employee>  queryEmloyeeListbyId(String id) {
       return mDaoRSession.getEmployeeDao().queryBuilder().where(EmployeeDao.Properties.Emp_id.eq(id)).list();

    }

    @Override
    public void cleanEmployeeAll() {
        mDaoWSession.getEmployeeDao().deleteAll();
    }

    @Override
    public List<Employee> queryEmloyeeList() {
        List<Employee> employeeList= mDaoRSession.getEmployeeDao().loadAll();
        return employeeList;
    }



    //人员详细信息表操作如下
    @Override
    public void addEmployeeList(EmployeeListBean bean) {
        mDaoWSession.getEmployeeListBeanDao().insert(bean);
    }

    @Override
    public void deleteEmployeeList(EmployeeListBean bean) {
        mDaoWSession.getEmployeeListBeanDao().delete(bean);
    }

    @Override
    public void updateEmployeeListBean(EmployeeListBean bean) {
        mDaoWSession.getEmployeeListBeanDao().update(bean);
    }

    @Override
    public List<EmployeeListBean> queryEmployeelistBeanbyId(String empid) {
        return mDaoRSession.getEmployeeListBeanDao().queryBuilder().where(EmployeeListBeanDao.Properties.Emp_id.eq(empid)).list();
    }

    @Override
    public void cleanEmployeeListBeanAll() {
        mDaoWSession.getEmployeeListBeanDao().deleteAll();
    }

    @Override
    public List<EmployeeListBean> queryEmployeeListBeanAll() {
        return null;
    }

    //考勤记录表操作
    @Override
    public void addAttendanceBo(AttendanceBo attendanceBo) {
        mDaoWSession.getAttendanceBoDao().insert(attendanceBo);
    }

    @Override
    public void deleteAttendanceBo(AttendanceBo attendanceBo) {
        mDaoWSession.getAttendanceBoDao().delete(attendanceBo);
    }

    @Override
    public void updatAttendanceBo(AttendanceBo attendanceBo) {
        mDaoWSession.getAttendanceBoDao().update(attendanceBo);
    }

    @Override
    public void cleanAttendanceBoAll() {
        mDaoWSession.getAttendanceBoDao().deleteAll();
    }

    @Override
    public List<AttendanceBo> queryAttendanceBoList() {
        return mDaoWSession.getAttendanceBoDao().loadAll();
    }
}
