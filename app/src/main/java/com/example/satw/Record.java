package com.example.satw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Record extends AppCompatActivity {
    Controller controller=Controller.getInstance();
    ListView record;
    Button button;
    Button back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        controller.setRecord_GUI(this);
        controller.setDB_activity(this);
        record = findViewById(R.id.listview5);
        back_btn = findViewById(R.id.button24);
        back_btn.setOnClickListener(back);
        button = findViewById(R.id.button23);
        button.setOnClickListener(re);
        record.setAdapter(controller.getAdapter());
    }
    private  View.OnClickListener re = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ArrayAdapter adapter = new ArrayAdapter(Record.this, android.R.layout.simple_list_item_1,controller.getR());
            record.setAdapter(adapter);

        }
    };
    private  View.OnClickListener back = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_menu_GUI();
        }
    };
}
