package com.example.satw;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBMgr {
    private Controller controller;
    private DBConnection dbConnection;
    private String db_result="";
    private static DBMgr instance = new DBMgr();
    private Activity activity;
    private DBMgr(){}
    public static DBMgr getInstance(){
        return instance;
    }
    private void reorganize_dbconnection(){
        dbConnection =new DBConnection();
    }
    public void setController (Controller controller){
        this.controller=controller;
    }
    public void setActivity(Activity activity){
        this.activity=activity;
    }
    public void login(String acc,String pass){
        reorganize_dbconnection();
        String phpfile="login.php";//放要執行的PHP檔
        //放要傳送的參數

        StringBuilder stringBuilder = new StringBuilder();

        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8")).append("&");
            stringBuilder.append("password=").append(URLEncoder.encode(pass,"UTF-8"));

        } catch (UnsupportedEncodingException e) {
            Log.e("Encoder",e.toString());
        }
        dbConnection.execute(phpfile,stringBuilder.toString());

    }
    public void login_success(String acc){
        reorganize_dbconnection();
        String url = "get_user_info.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dbConnection.execute(url,stringBuilder.toString());
    }
    public void set_result(String result){//接收DB傳回來的資訊
        this.db_result=result;
        try {
            if(!TextUtils.isEmpty(result)) {
                controller.db_load_finish(new JSONObject(result));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void create_account(String name,String email,String acc,String pwd){
        reorganize_dbconnection();
        String url = "create_account.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("name=").append(URLEncoder.encode(name,"UTF-8")).append("&");
            stringBuilder.append("mail=").append(URLEncoder.encode(email,"UTF-8")).append("&");
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8")).append("&");
            stringBuilder.append("password=").append(URLEncoder.encode(pwd,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dbConnection.execute(url,stringBuilder.toString());
    }
    public void update_balance(String acc,int balance_int){
        reorganize_dbconnection();
        String balance = String.valueOf(balance_int);
        String url = "update_wallet.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8")).append("&");
            stringBuilder.append("balance=").append(URLEncoder.encode(balance,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dbConnection.execute(url,stringBuilder.toString());
    }
    public void update_recevier(String acc,int balance_int){
        reorganize_dbconnection();
        String balance = String.valueOf(balance_int);
        String url = "transfer_update.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8")).append("&");
            stringBuilder.append("balance=").append(URLEncoder.encode(balance,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dbConnection.execute(url,stringBuilder.toString());
    }
    public void insert_record(String acc,String item_id, String cost){
        reorganize_dbconnection();
        String url = "insert_record.php";
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        int i =3;
        String s = String.valueOf(i);
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8")).append("&");
            stringBuilder.append("item=").append(URLEncoder.encode(item_id,"UTF-8")).append("&");
            stringBuilder.append("date=").append(URLEncoder.encode(sdFormat.format(date),"UTF-8")).append("&");
            stringBuilder.append("cost=").append(URLEncoder.encode(cost,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dbConnection.execute(url,stringBuilder.toString());
    }
    public void load_record(String acc){
        reorganize_dbconnection();
        String url = "get_record.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dbConnection.execute(url,stringBuilder.toString());
    }

    public void isexist_acc(String acc) {
        reorganize_dbconnection();
        String url = "isexist_acc.php";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("account=").append(URLEncoder.encode(acc, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        dbConnection.execute(url, stringBuilder.toString());
    }
}
