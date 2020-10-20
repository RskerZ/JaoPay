package com.example.satw;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecordList extends Control {
    public RecordList(Controller controller){
        super(controller);
    }
    String record;
    protected ArrayList<String> list = new ArrayList<>();
    @Override
    protected void process(JSONObject result) {
        try {
            JSONArray jsonArray = result.getJSONArray("record");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jo = jsonArray.getJSONObject(i);
                String date = jo.get("date").toString();
                String item = jo.get("item").toString();
                String cost = jo.get("cost").toString();
                String space="";
                if (item.length()<11) {
                    for (int a = 16; a > item.length(); a--) {
                        space = space + "  ";
                    }
                }else{
                    for(int a =20; a>item.length();a--){
                        space=space+" ";
                    }

                }
                for (int b = 13 ; b>cost.length();b--){
                    space=space+" ";
                }

                record=date+"         "+item+space+cost;

                setRecord(record);
//                Log.e("list",record);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    controller.setList(list);
        Log.e("4444",controller.getR().toString());
    }
    protected void setRecord(String record){
        list.add(record);
    }

}
