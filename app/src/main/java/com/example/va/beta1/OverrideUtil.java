package com.example.va.beta1;


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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_VOLUME_DOWN == event.getKeyCode()) {
            IntentUtil.processIntent(getApplicationContext(),AppConstants.INTENT_MAKE_CALL,"+919940660797");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
