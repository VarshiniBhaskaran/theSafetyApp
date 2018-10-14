package com.example.va.beta1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by arun-5714 on 13/10/18.
 */

public class IntentUtil extends Application {

    private static Logger LOGGER = Logger.getLogger("IntentUtil");
    private static Intent intent = null;

    public static void processIntent(Context context,String intentType,String action){

        try {
            if (intentType != null && action != null) {
                switch (intentType) {
                    case AppConstants.INTENT_MAKE_CALL:
                        intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+  action.split(",")[0]));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        break;
                    default:
                        break;
                }
            }
            if(intent != null)
            {

                context.startActivity(intent);
            }
        }catch(Exception e)
        {
            LOGGER.log(Level.SEVERE,":::: Error in processIntent in IntentUtil :::: ",e);
        }
    }
}
