package com.th.guangxismz.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class DPDB {
	private static SharedPreferences reader = null;
	private static SharedPreferences.Editor writer = null;
	private static Context mContext = null;
	private static DPDB instance = null;
	public static final String tag = "DPDb";
	public DPDB() {
		super();
		// TODO Auto-generated constructor stub
	}
	/** 初始化读写 */
	public static DPDB InitDPDbRW(Context context) {
		if (instance == null) {
			instance = new DPDB();
			mContext = context;
			reader = mContext
					.getSharedPreferences("DPDB", Context.MODE_PRIVATE);
			writer = mContext
					.getSharedPreferences("DPDB", Context.MODE_PRIVATE).edit();
		}
		return instance;
	}

	public static boolean isRead() {
		if (reader == null) {
			Log.e(tag, "reader = null,may be not call InitRW() methods");
			if(mContext == null){
				Log.e("DPDB", "mContext == null");
				return false;
			}
			reader = mContext.getSharedPreferences("DPDB", Context.MODE_PRIVATE);
			return false;
		}
		return true;
	}

	public static boolean isWrite() {
		if (writer == null) {
			if(mContext == null){
				Log.e("DPDB", "mContext == null");
				return false;
			}
			writer = mContext
					.getSharedPreferences("DPDB", Context.MODE_PRIVATE).edit();
			Log.e(tag, "writer = null,may be not call InitRW() methods");
			return false;
		}
		return true;
	}



	/**保存项目名称*/
	public static boolean setProjectName(String pname) {
		if (!isWrite()) {
			return false;
		}
		writer.putString("ProjectName", pname);
		return writer.commit();
	}

	/** 获取项目名称 */
	public static String getProjectName() {
		if (!isRead()) {
			return "";
		}
		return reader.getString("ProjectName","");
	}

	public static boolean setPersonCount(int count) {
		if (!isWrite()) {
			return false;
		}
		writer.putInt("PersonCount", count);
		return writer.commit();
	}

	public static int getPersonCount() {
		if (!isRead()) {
			return -1;
		}
		return reader.getInt("PersonCount",-1);
	}


}






















