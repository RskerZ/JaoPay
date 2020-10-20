package com.example.satw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.satw.Item.BMW;
import com.example.satw.Item.Co;
import com.example.satw.Item.Fuckla;
import com.example.satw.Item.HatT;
import com.example.satw.Item.IphonePro;
import com.example.satw.Item.IphoneSe;
import com.example.satw.Item.Note10;
import com.example.satw.Item.S10;
import com.example.satw.Item.Wash;

public class Purchase extends AppCompatActivity {

    ImageView bmw_Image;
    ImageView wash_Image;
    ImageView fuckla_Image;
    ImageView iphonepro_Image;
    ImageView iphonese_Image;
    ImageView co_Image;
    ImageView hatt_Image;
    ImageView s10_Image;
    ImageView note10_Image;
    Button back_btn;
    Controller controller = Controller.getInstance();
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        bmw_Image = findViewById(R.id.imageView12);
        bmw_Image.setOnClickListener(bmw_GUI);
        wash_Image = findViewById(R.id.imageView3);
        wash_Image.setOnClickListener(wash_GUI);
        co_Image = findViewById(R.id.imageView2);
        co_Image.setOnClickListener(co_GUI);
        hatt_Image = findViewById(R.id.imageView8);
        hatt_Image.setOnClickListener(hatt_GUI);
        s10_Image = findViewById(R.id.imageView6);
        s10_Image.setOnClickListener(s10_GUI);
        iphonepro_Image = findViewById(R.id.imageView);
        iphonepro_Image.setOnClickListener(iphonepro_GUI);
        iphonese_Image = findViewById(R.id.imageView11);
        iphonese_Image.setOnClickListener(iphonese_GUI);
        note10_Image = findViewById(R.id.imageView9);
        note10_Image.setOnClickListener(note10_GUI);
        fuckla_Image = findViewById(R.id.imageView7);
        fuckla_Image.setOnClickListener(fuckla_GUI);
        back_btn = findViewById(R.id.button15);
        back_btn.setOnClickListener(back);
        controller.setPurchase_GUI(this);
        controller.setDB_activity(this);
        controller.setActivity(this);
        t1 = findViewById(R.id.textView21);
        t1.setSelected(true);
    }
    private View.OnClickListener bmw_GUI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent();
            intent.setClass(Purchase.this, BMW.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener wash_GUI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent();
            intent.setClass(Purchase.this, Wash.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener co_GUI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent();
            intent.setClass(Purchase.this, Co.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener hatt_GUI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent();
            intent.setClass(Purchase.this, HatT.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener s10_GUI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent();
            intent.setClass(Purchase.this, S10.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener iphonepro_GUI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent();
            intent.setClass(Purchase.this, IphonePro.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener iphonese_GUI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent();
            intent.setClass(Purchase.this, IphoneSe.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener note10_GUI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent();
            intent.setClass(Purchase.this, Note10.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener fuckla_GUI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent();
            intent.setClass(Purchase.this, Fuckla.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener back = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            controller.show_menu_GUI();
        }
    };
}
