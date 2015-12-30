package hansheng.com.zxingdemo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hansheng on 2015/12/30.
 */
class PreferenceManager {

    private static SharedPreferences getSharedPreferences(final Context context) {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context);
    }
    public static boolean putString(final Context context, final String key, final String pValue) {
        final SharedPreferences.Editor editor = PreferenceManager.getSharedPreferences(context).edit();

        editor.putString(key, pValue);

        return editor.commit();
    }

    public static String getString(final Context context, final String key, final String defaultValue) {
        return PreferenceManager.getSharedPreferences(context).getString(key, defaultValue);
    }

    public static Theme getCurrentTheme(Context context) {
        return Theme.valueOf(PreferenceManager.getString(context, "app_theme", Theme.Blue.name()));
    }


    public static void setCurrentTheme(Context context, Theme currentTheme) {
        PreferenceManager.putString(context, "app_theme", currentTheme.name());
    }
}

