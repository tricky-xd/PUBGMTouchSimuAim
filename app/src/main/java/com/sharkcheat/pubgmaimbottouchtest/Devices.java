package com.sharkcheat.pubgmaimbottouchtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.view.Gravity;
import android.view.WindowManager;

import java.util.UUID;

public class Devices {

    public static String getUniqueId(Context ctx) {
        @SuppressLint("HardwareIds")
        String key = (getDeviceName() + Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.ANDROID_ID) + Build.HARDWARE).replace(" ", "");
        UUID uniqueKey = UUID.nameUUIDFromBytes(key.getBytes());
        return uniqueKey.toString().replace("-", "");
    }
    public static int getWidth(Context context) {
        WindowManager mWm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        mWm.getDefaultDisplay().getRealSize(point);
        return point.x;
    }
    public static int getHeight(Context context) {
        WindowManager mWm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        mWm.getDefaultDisplay().getRealSize(point);
        return point.y;
    }
    private static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        } else {
            return manufacturer + " " + model;
        }
    }



}
