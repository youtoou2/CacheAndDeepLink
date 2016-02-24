package utoo.offlinecacheanddeeplink.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSettings {

	private static Context sApplicationContext;
	private static final String SHARED_PREF_NAME = "CacheCheckPref";

	private static final String KEY_QUESTION_ID = "KEY_QUESTION_ID";
	private static final String KEY_PROFILE_ID = "KEY_PROFILE_ID";
	public static void setApplicationContext(Context context) {
		sApplicationContext = context;
	}

	private static SharedPreferences getSharedPreferences() {
		return getSharedPreferences(SHARED_PREF_NAME);
	}

	private static SharedPreferences getSharedPreferences(String prefName) {
		SharedPreferences preferences = sApplicationContext.getSharedPreferences(prefName, Context.MODE_PRIVATE);
		return preferences;
	}

	private static void clearPreferences(String prefName) {
		SharedPreferences.Editor editor = getSharedPreferences(prefName).edit();
		editor.clear();
		editor.commit();
	}

	private static void setBooleanPref(String key, boolean value) {
		SharedPreferences.Editor editor = getSharedPreferences().edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	private static void setIntPref(String key, int value) {
		SharedPreferences.Editor editor = getSharedPreferences().edit();
		editor.putInt(key, value);
		editor.commit();
	}

	private static void setLongPrefForDouble(String key, double value) {
		SharedPreferences.Editor editor = getSharedPreferences().edit();
		editor.putLong(key, Double.doubleToLongBits(value));
		editor.commit();
	}

	private static void setLongPref(String key, long value) {
		SharedPreferences.Editor editor = getSharedPreferences().edit();
		editor.putLong(key, value);
		editor.commit();
	}

	private static double getDoubleFromLongPref(String key) {
		return Double.longBitsToDouble(getSharedPreferences().getLong(key, 0));
	}

	private static void setStringPref(String key, String value) {
		SharedPreferences.Editor editor = getSharedPreferences().edit();
		editor.putString(key, value);
		editor.commit();
	}

	public static void setKeyQuestionId(long id) {
		setLongPref(KEY_QUESTION_ID, id);
	}

	public static long getKeyQuestionId() {
		return getSharedPreferences().getLong(KEY_QUESTION_ID, 0l);
	}
	public static void setKeyProfileId(long id) {
		setLongPref(KEY_PROFILE_ID, id);
	}

	public static long getKeyProfileID() {
		return getSharedPreferences().getLong(KEY_PROFILE_ID, 0l);
	}
}