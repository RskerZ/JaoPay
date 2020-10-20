package com.example.satw;

import androidx.appcompat.app.AppCompatActivity;


import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Transfer extends AppCompatActivity {
    Button mail;
    Button trans_btn;
    Button cancel_btn;
    EditText otp;
    EditText acc;
    EditText money;
    Controller controller =  Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        mail = findViewById(R.id.button12);
        controller.setDB_activity(this);
        controller.setTransfer_GUI(this);
        controller.setActivity(this);
        mail.setOnClickListener(sendmail);
        otp = findViewById(R.id.editText11);
        acc = findViewById(R.id.editText9);
        money = findViewById(R.id.editText10);
        trans_btn = findViewById(R.id.button13);
        trans_btn.setOnClickListener(transfer);
        cancel_btn = findViewById(R.id.button14);
        cancel_btn.setOnClickListener(cancel);
    }

    private  View.OnClickListener sendmail = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.checkReceiverAcc(acc.getText().toString());
        }
    };
    private  View.OnClickListener transfer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.checkOTP(otp.getText().toString());
        }
    };

    private  View.OnClickListener cancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_menu_GUI();
        }
    };
    public String getMoney(){
        return money.getText().toString();
    }
    public String getAcc(){
        return acc.getText().toString();
    }
}



