package com.example.satw;

import android.view.Gravity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class Login_Success extends Control {
    public Login_Success(Controller controller){
        super(controller);
    }

    protected void process(JSONObject result){

        try {
            String name= result.get("name").toString();
            String email=result.get("mail").toString();
            int balance=Integer.parseInt(result.get("balance").toString());

            controller.setuserInfo(name,email,balance);
            if(controller.mainActivity!=null) {

                Toast toast = Toast.makeText(controller.mainActivity, "歡 迎 進 入 JaoPay", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 120);
                toast.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
