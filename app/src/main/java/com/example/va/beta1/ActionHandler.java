package com.example.va.beta1;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;

import com.example.va.beta1.database.DBUtil;

public class ActionHandler {

    public static String configureActionForKey(Activity activity, String mobile) throws Exception
    {
        Map<String,String> keyValueMap = new HashMap<>();
        keyValueMap.put("Mobile" , mobile);
        DBUtil db = new DBUtil();
        return db.storeInSharedPreferences(activity, keyValueMap);
    }

}
