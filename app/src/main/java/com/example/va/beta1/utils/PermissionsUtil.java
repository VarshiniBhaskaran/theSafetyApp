package com.example.va.beta1.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by arun-5714 on 13/10/18.
 */

public class PermissionsUtil extends AppCompatActivity {

    private static final Logger LOGGER = Logger.getLogger("PermissionsUtil");
    public static void checkFixPermissions(Activity activity,Context context, List<String> permissionsList) throws Exception
    {
        if(permissionsList != null && permissionsList.size() > 0)
        {
            for(int i=0;i<permissionsList.size();i++)
            {
                String currentPermission = permissionsList.get(i);
                if(!isPermissionGranted(context,currentPermission))
                {
                    requestPermission(activity,new String[]{currentPermission},1);
                }

            }
        }
    }

    public static Boolean isPermissionGranted(Context context,String permissionName) throws Exception
    {
        return ContextCompat.checkSelfPermission(context, permissionName) == 1 ? true : false;
    }

    public static void requestPermission(Activity activity,String[] permission,int requestCode) throws Exception
    {
        ActivityCompat.requestPermissions(activity,permission,1);
    }

    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){
        LOGGER.log(Level.INFO,"Overridden Permissions Method");
    }

}
