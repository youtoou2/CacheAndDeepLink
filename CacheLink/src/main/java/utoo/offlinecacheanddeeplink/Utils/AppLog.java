package utoo.offlinecacheanddeeplink.Utils;

import android.util.Log;

public class AppLog {
	
	private static final String LOG_NAME = "utoo.offlinecache";

	public static void e(String msg) {
		if(AppConfig.IS_LOG) Log.e(LOG_NAME, msg);
	}
	
	public static void d(String msg) {
		if(AppConfig.IS_LOG) Log.d(LOG_NAME, msg);
	}
	
	public static void w(String msg) {
		if(AppConfig.IS_LOG) Log.w(LOG_NAME, msg);
	}
	
	public static void i(String msg) {
		if(AppConfig.IS_LOG) Log.i(LOG_NAME, msg);
	}
	
	public static void v(String msg) {
		if(AppConfig.IS_LOG) Log.v(LOG_NAME, msg);
	}

}
