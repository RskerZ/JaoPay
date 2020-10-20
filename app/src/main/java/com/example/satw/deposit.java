package com.example.satw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class deposit extends AppCompatActivity {

    Button confirm_btn;
    Button cancel_btn;
    EditText money_text;
    Controller controller = Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        confirm_btn = findViewById(R.id.button8);
        cancel_btn = findViewById(R.id.button11);
        money_text = findViewById(R.id.editText8);
        confirm_btn.setOnClickListener(deposit);
        cancel_btn.setOnClickListener(cancel);
        controller.setDeposit_GUI(this);
        controller.setDB_activity(this);
        controller.setActivity(this);
    }
    private View.OnClickListener deposit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                controller.deposit(money_text.getText().toString());
                controller.show_menu_GUI();
            }catch (NumberFormatException e){
                controller.make_toast("您未輸入金額!!");
            }
        }
    };

    private  View.OnClickListener cancel = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_menu_GUI();
        }
    };


}
