package com.example.satw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AccInfo extends AppCompatActivity {
    TextView accInfo;
    Button connfirm_btn;
    Controller controller = Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_info);
        accInfo = findViewById(R.id.textView17);
        connfirm_btn = findViewById(R.id.button21);
        accInfo.setText(controller.showInfo());
        connfirm_btn.setOnClickListener(confirm);
    }
    private View.OnClickListener confirm = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_menu_GUI();

        }
    };
}
