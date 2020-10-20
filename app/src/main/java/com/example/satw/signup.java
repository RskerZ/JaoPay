package com.example.satw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText name;
    EditText mail;
    EditText account;
    EditText password;
    EditText passcheck;
    Button sign_btn;
    Button cancel_btn;
    Controller controller =  Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        controller.setup();
        controller.setSignup_GUI(this);
        sign_btn = findViewById(R.id.button6);
        sign_btn.setOnClickListener(signup);
        name = findViewById(R.id.editText3);
        mail = findViewById(R.id.editText4);
        account = findViewById(R.id.editText5);
        password = findViewById(R.id.editText6);
        passcheck = findViewById(R.id.editText7);
        cancel_btn = findViewById(R.id.button7);
        cancel_btn.setOnClickListener(cancel);

    }

    private  View.OnClickListener signup = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(password.getText().toString().equals(passcheck.getText().toString())){
                controller.signup(name.getText().toString(),mail.getText().toString(),account.getText().toString(),password.getText().toString());

            }else{
                Toast.makeText(signup.this, "密碼不一致", Toast.LENGTH_LONG).show();
            }
        }
    };
    private  View.OnClickListener cancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_home_GUI();
        }
    };




}
