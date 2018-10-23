package com.example.va.beta1.utils;


import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.example.va.beta1.CommonUtil;
import com.example.va.beta1.constants.AppConstants;

import java.util.logging.Logger;

/**
 * Created by arun-5714 on 13/10/18.
 */

public class OverrideUtil extends AppCompatActivity {

    private static Logger LOGGER = Logger.getLogger("OverrideUtil");


    public boolean onKeyDown(Activity activity, Context context, int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_VOLUME_DOWN == event.getKeyCode()) {
            IntentUtil.processIntent(context, AppConstants.INTENT_MAKE_CALL,CommonUtil.fetchValueForKey(activity, "Mobile"));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
