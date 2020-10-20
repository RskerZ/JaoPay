package com.example.satw;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DBConnection extends AsyncTask<String,Integer,String> {


        private DBMgr dbMgr;
        private String result="";
//        private String ip="http://192.168.2.114/SQL/";//要改成自己的IP，手機跟電腦要連同個網路
        private String ip="http://192.168.1.101/php/";
        private HttpURLConnection connection;

        protected void onPreExecute(){
            this.dbMgr = DBMgr.getInstance();
        }

        protected String doInBackground(String... parmeter){
            post(parmeter);
            return result;
        }
        protected void onPostExecute(String result){
           if(!TextUtils.isEmpty(result)) {
               dbMgr.set_result(result);
           }

        }
        private void post(String... data)  {

            try {
                String url_s = ip+data[0];//PHP的網址
                String  paremeter = data[1] ;//要post的資料
                Log.e("data",data[0]);
                Log.e("ip",url_s);
                Log.e("args",paremeter);
                Log.e("post", "post: "+ paremeter);
                URL url = new URL(url_s);
                connection =(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setUseCaches(false);
                connection.setConnectTimeout(10000);
                connection.setReadTimeout(10000);
                DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
                String post_string = paremeter;

                outputStream.writeBytes(post_string);
                outputStream.flush();
                outputStream.close();

                InputStream inputStream = connection.getInputStream();
                int status = connection.getResponseCode();
                //Log.e("status", "post: "+ status);
                if(status == 200){
                    if(inputStream != null){
                        InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
                        BufferedReader in = new BufferedReader(reader);
                        String line="";
                        while ((line=in.readLine()) != null){
                            result+=line + "\n";
                        }
                    }else {
                        result="{\"Error\":\"NO data\"}";
                    }
                }else {
                    result ="{\"Error\":\"DBMgr connection fail check your net\"}";
                }
                inputStream.close();
                connection.disconnect();
            }catch (IOException e){
                result = "{\"Error\":\"DBMgr connection fail\"}";

                Log.e("DBMgr connect",e.toString());
            }

        }


}
