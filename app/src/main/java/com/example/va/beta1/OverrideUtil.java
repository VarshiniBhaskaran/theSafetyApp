package com.example.va.beta1;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by arun-5714 on 13/10/18.
 */

public class OverrideUtil extends AppCompatActivity {

    private static Logger LOGGER = Logger.getLogger("OverrideUtil");


    public boolean onKeyDown(Activity activity, Context context, int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_VOLUME_DOWN == event.getKeyCode()) {
            IntentUtil.processIntent(context, AppConstants.INTENT_MAKE_CALL,fetchNumbersForAction(activity));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private String fetchNumbersForAction(Activity activity){
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString("Mobile", "");
    }
}
