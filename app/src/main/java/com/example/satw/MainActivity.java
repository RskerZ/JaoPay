package com.example.satw;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText account;
    EditText pass;
    Controller controller =  Controller.getInstance();

    private static MainActivity instance = new MainActivity();
    public static MainActivity getInstance(){
        return instance;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(loginverify);
        account =(EditText) findViewById(R.id.editText2);
        pass = findViewById(R.id.editText);
        Button btn_signup =findViewById(R.id.button2);
        btn_signup.setOnClickListener(signup);
        controller.setup();
        controller.setMainActivity(this);
        controller.setActivity(this);
    }

    private View.OnClickListener loginverify = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent intent = new Intent();
//            intent.setClass(MainActivity.this, menu.class);
//            if(controller.login(account.getText().toString(),pass.getText().toString())){
//                startActivity(intent);
//            }else{
//                text.setText( account.getText().toString());
//            }
            controller.login(account.getText().toString(),pass.getText().toString());
        }
    };

    private  View.OnClickListener signup = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent  = new Intent();
            intent.setClass(MainActivity.this,signup.class);
            startActivity(intent);


        }
    };
}
