package com.example.satw;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Random;

public class OTP {
    Controller controller ;
    private static OTP otp = new OTP();
    private OTP(){
        controller = Controller.getInstance();
    }
    public static OTP getInstance(){
        return otp;
    }
    private String password="";
    TextView time;
    public void create_password(){
        password="";
        time = controller.activity.findViewById(R.id.textView19);
        Random random = new Random();
        while (password.length() != 6){
            password+=random.nextInt(9);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                controller.Sendmail(password);
            }
        }).start();
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("剩餘時間 " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                time.setText("超過時間！請重新操作");
                resetPassword();
            }
        }.start();
    }
    public void resetPassword(){password = "%$#%#$^&&GSDG";}
    public String getPassword(){
        return password;
    }
    public void check_otp(String enter){
        if (otp.getPassword().equals(enter)){
                controller.transfer();
        }else{
            controller.make_toast("驗證碼錯誤");
        }
    }
    public void check_otp_payment(String enter){
        if (otp.getPassword().equals(enter)){
                controller.payment();
        }else{
            controller.make_toast("驗證碼錯誤");
        }
    }
}
