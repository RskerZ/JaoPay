package com.example.satw.Item;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.satw.Controller;
import com.example.satw.R;

public class BMW extends AppCompatActivity {
    Button purchase_btn;
    Button return_btn;
    Controller controller = Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmw);
        purchase_btn = findViewById(R.id.button20);
        purchase_btn.setOnClickListener(purchase);
        return_btn = findViewById(R.id.button15);
        return_btn.setOnClickListener(back);
        controller.setBmw_GUI(this);
        controller.setActivity(this);
    }
    private View.OnClickListener purchase = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.setIteminfo("i:bmw",1000000);
            controller.show_purchase_page_GUI(BMW.this);
        }
    };
    private View.OnClickListener back = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_purchase_GUI();
        }
    };
}
