package com.example.android.background.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;

import static android.content.Context.BATTERY_SERVICE;

/**
 * Created by nataliac on 4/10/18.
 */

public class BatteryUtils {

    public static boolean isBatteryCharging(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            BatteryManager batteryManager = (BatteryManager) context.getSystemService(BATTERY_SERVICE);
            return batteryManager.isCharging();
        }
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, 0);

        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;

        return isCharging;
    }
}
