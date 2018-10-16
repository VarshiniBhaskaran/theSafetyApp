package com.example.va.beta1.database;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.example.va.beta1.R;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil extends AppCompatActivity {
    private static Logger LOGGER = Logger.getLogger("DBUtil");

    public  void storeInSharedPreferences(Activity activity, Map<String,String> values) {
        try{
            SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            for( Map.Entry<String, String> entry : values.entrySet()){
                editor.putString(entry.getKey(),  entry.getValue());
            }

            editor.commit();
        }catch(Exception e){
            LOGGER.log(Level.INFO,"exception-",e);
        }

    }



}
