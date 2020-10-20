package com.example.satw;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends Control{
    public login(Controller controller){
       super(controller);
    }
//    String str ="123";
//    public boolean loginverify(String acc,String pass){
//         if(acc.equals(str)&& pass.equals(str)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    public String fuck(){
//        return "123";
//    }
    protected void process(JSONObject result){

        if(result.has("Successful")){

           controller.login_success();
            controller.show_menu_GUI();
        }else{
            controller.make_toast("帳號或密碼錯誤!");
        }


}
}
