package com.example.satw;

import android.app.Activity;
import android.os.CountDownTimer;
import android.widget.TextView;

import org.json.JSONObject;

public class CheckAccExist extends Control{
    public CheckAccExist(Controller controller){
        super(controller);
    }
    @Override
    protected void process(JSONObject result) {
        if(result.has("NOTEmpty")){
            controller.createOTP();
        }else if(result.has("CANNOT")){
            controller.make_toast("查無此帳號，請重新輸入!");
        }
    }
}
