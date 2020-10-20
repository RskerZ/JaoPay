package com.example.satw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class menu extends AppCompatActivity {
    private Controller controller;
    Button deposit_btn;
    Button transfer_btn;
    Button purchase_btn;
    Button robot_btn;
    Button record_btn;
    Button accinfo_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        deposit_btn = findViewById(R.id.button4);
        transfer_btn = findViewById(R.id.button3);
        purchase_btn = findViewById(R.id.button9);
        record_btn = findViewById(R.id.button5);
        robot_btn = findViewById(R.id.robot);
        accinfo_btn = findViewById(R.id.button10);
        deposit_btn.setOnClickListener(deposit);
        transfer_btn.setOnClickListener(transfer);
        controller = Controller.getInstance();
        controller.setup();
        controller.setMenu_GUI_GUI(this);
        purchase_btn.setOnClickListener(purchase);
        record_btn.setOnClickListener(record);
        accinfo_btn.setOnClickListener(accinfo);
        robot_btn.setOnClickListener(robot);


    }

    private View.OnClickListener deposit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_deposit_GUI();
        }
    };
    private View.OnClickListener transfer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_transfer_GUI();
        }
    };
    private View.OnClickListener purchase = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_purchase_GUI();
        }
    };
    private View.OnClickListener record = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.record(controller.user.getAcc());
            controller.show_record_GUI();
        }
    };
    private View.OnClickListener accinfo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_accinfo_GUI();
        }
    };
    private View.OnClickListener robot = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_robot_GUI();
        }
    };
}
