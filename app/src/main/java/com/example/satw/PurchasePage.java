package com.example.satw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class PurchasePage extends AppCompatActivity {
    EditText otp;
    Button confirm_btn;
    Button cancel_btn;
    Button otp_btn;
    TextView time;
    Controller controller = Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_page);
        controller.setPurchase_page_GUI(this);
        controller.setDB_activity(this);
        controller.setActivity(this);
        otp = findViewById(R.id.editText15);
        confirm_btn = findViewById(R.id.button18);
        cancel_btn = findViewById(R.id.button22);
        time = findViewById(R.id.textView19);
        confirm_btn.setOnClickListener(purchase);
        cancel_btn.setOnClickListener(cancel);
        otp_btn = findViewById(R.id.button17);
        otp_btn.setOnClickListener(sendmail);

    }
    private View.OnClickListener purchase = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.checkOTP_payment(otp.getText().toString());
        }
    };
    private View.OnClickListener cancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_purchase_GUI();
        }
    };
    private  View.OnClickListener sendmail = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    Looper.prepare();
                    controller.createOTP_Payment();
                    Looper.loop();
                }
            }).start();

        }
    };

}
