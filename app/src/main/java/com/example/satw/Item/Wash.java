package com.example.satw.Item;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.satw.R;
import com.example.satw.Controller;
public class Wash extends AppCompatActivity {
    Button purchase_btn;
    Button return_btn;
    Controller controller = Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash);
        purchase_btn = findViewById(R.id.button20);
        purchase_btn.setOnClickListener(purchase);
        controller.setActivity(this);
        return_btn = findViewById(R.id.button15);
        return_btn.setOnClickListener(back);
    }
    private View.OnClickListener purchase = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.setIteminfo("i:detergent",50);
            controller.show_purchase_page_GUI(Wash.this);
        }
    };
    private View.OnClickListener back = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_purchase_GUI();
        }
    };
}
