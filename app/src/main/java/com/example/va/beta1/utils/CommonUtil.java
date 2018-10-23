package com.example.va.beta1;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.util.List;

/**
 * Created by arun-5714 on 13/10/18.
 */

public class CommonUtil {

    public static String fetchValueForKey(Activity activity,String key){
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString(key, "");
    }

}
