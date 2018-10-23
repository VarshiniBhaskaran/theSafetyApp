package com.example.va.beta1.database;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.example.va.beta1.constants.AppConstants;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil extends AppCompatActivity
{
    private static Logger LOGGER = Logger.getLogger("DBUtil");

    public String storeInSharedPreferences(Activity activity, Map<String,String> values) {
        try{
            SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            for( Map.Entry<String, String> entry : values.entrySet()){
                editor.putString(entry.getKey(),  entry.getValue());
            }

            editor.commit();
            return AppConstants.SUCCESS;
        }catch(Exception e){
            LOGGER.log(Level.INFO,":::: Exception in storeInSharedPreferences :::: ",e);
            return AppConstants.FAILURE;
        }

    }



}
