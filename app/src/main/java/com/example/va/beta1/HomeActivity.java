package com.example.va.beta1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.va.beta1.utils.OverrideUtil;
import com.example.va.beta1.utils.PermissionsUtil;
import com.example.va.beta1.constants.AppConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomeActivity extends AppCompatActivity {

    private static Logger LOGGER = Logger.getLogger("HomeActivity");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(R.layout.activity_home);
    }

    private void init()
    {
        try{
            List<String> permissionList = new ArrayList<String>();
            permissionList.add("android.permission.CALL_PHONE");
            PermissionsUtil.checkFixPermissions(this,getApplicationContext(),permissionList);
        }catch (Exception e)
        {
            LOGGER.log(Level.SEVERE,"::: Error in init :::: ",e);
        }
    }

    public void buttonAction(View view)
    {
        EditText edit = (EditText)findViewById(R.id.mobileNumber);
        String mobile = edit.getText().toString(), toastText = AppConstants.FAILURE;
        try {
            if(view != null)
            {
                switch(view.getId()) {
                    case R.id.setButton:
                        toastText = ActionHandler.configureActionForKey(this, mobile);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            toastText = toastText.equalsIgnoreCase(AppConstants.SUCCESS) ? AppConstants.ACTION_CONFIGURED : AppConstants.ACTION_FAILURE;
            Toast.makeText(getApplicationContext(),toastText, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       OverrideUtil override = new OverrideUtil();
       return override.onKeyDown(this, getApplicationContext(), keyCode,event);
    }
}

