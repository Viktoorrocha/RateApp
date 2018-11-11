package viktorrocha.br.com.rateapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class RateSPManager {
    private static final String LAUNCHH_TIMES_KEY = "launch_times_key";
    private static final int LAUNCH_TIMES = 3;
    private static SharedPreferences getSP(Context c){
        return c.getSharedPreferences("preferences",Context.MODE_PRIVATE);
    }

    public static void updateLaunchTimes(Context c ){
        SharedPreferences sp = getSP(c);
        sp.edit().putInt(LAUNCHH_TIMES_KEY,0).apply();
    }

    public static void updateLaunchTimes(Context c, Bundle savedInstanceState){
        if(savedInstanceState != null){
            return;
        }

        SharedPreferences sp = getSP(c);
        int launchTimes = sp.getInt(LAUNCHH_TIMES_KEY,0);
        sp.edit().putInt(LAUNCHH_TIMES_KEY, launchTimes + 1).apply();
    }

    private static boolean isLaunchTimesValid(Context c){
        SharedPreferences sp = getSP(c);
        int launchTimes = sp.getInt(LAUNCHH_TIMES_KEY,0);

        return launchTimes > 0 && launchTimes % LAUNCH_TIMES == 0;
    }
}
