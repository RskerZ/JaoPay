package com.example.satw;

import org.json.JSONObject;

public class Account extends Control{
    public Account(Controller controller){
        super(controller);
    }
    public void process(JSONObject result){
        if(result.has("Successful")){
            controller.show_home_GUI();
        }else{
            controller.make_toast("帳號或密碼錯誤");
        }
    }
}
