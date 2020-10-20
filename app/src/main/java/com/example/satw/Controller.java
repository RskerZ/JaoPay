package com.example.satw;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.satw.Item.BMW;
import com.example.satw.Item.Item;
import com.example.satw.Robot.ChatActivity;

import org.json.JSONObject;

import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Controller {

    protected Control control;
    private static Controller controller = new Controller();
    protected MainActivity mainActivity;
    protected Activity activity;
    protected signup sign;
    protected menu menu_GUI;
    protected User user;
    protected OTP otp;
    protected Item item;
    protected PurchasePage purchase_page_GUI;
    protected Record record_GUI;
    protected deposit deposit_GUI;
    protected Transfer transfer_GUI;
    protected Purchase purchase_GUI;
    protected BMW bmw_GUI;
    protected DBMgr dbMgr = DBMgr.getInstance();
    private String temp_acc;
    protected ArrayList<String> list = new ArrayList<>();

    public  static  Controller getInstance(){
        return controller;
    }
    public void setup(){
        dbMgr.setController(this);
        user=User.getInstance();
        otp=OTP.getInstance();

    }
    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        dbMgr.setActivity(mainActivity);
    }
    public void setuserInfo(String name,String email,int balance){
        user.setAcc(temp_acc);
        user.setEmail(email);
        user.setName(name);
        user.setBalance(balance);

    }
    public void setActivity(Activity activity){
        this.activity = activity;
    }
    public void login(String acc,String pass){
         control=new login(this);
         dbMgr.login(acc,pass);
         temp_acc=acc;
    }
    public void record(String acc){
        control=new RecordList(this);
        dbMgr.load_record(acc);

    }
    public void login_success(){
        control=new Login_Success(this);
        dbMgr.login_success(temp_acc);
    }
    public void signup(String name,String mail,String account,String password){
        control=new Account(this);
        dbMgr.create_account(name,mail,account,password);
    }
    public void deposit(String money){
            int temp = Integer.parseInt(money) ;
            user.deposit(temp);
            dbMgr.update_balance(user.getAcc(),user.getBalance());
            make_toast("儲值完成!!");
    }
    public void make_toast(String msg){
        Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show();
    }
    public void Sendmail(String otp){
        try {
            EmailSender sender = new EmailSender();
            //设置服务器地址和端口，网上搜的到
            sender.setProperties("smtp.gmail.com", "587");
            //分别设置发件人，邮件标题和文本内容
            sender.setMessage("satwjaopay@gmail.com", "OTP code", otp);
            //设置收件人
            sender.setReceiver(new String[]{user.getEmail()});
            //添加附件

            //发送邮件
            sender.sendEmail("smtp.gmail.com", "satwjaopay@gmail.com", "gsdzqqqfihxrywsr");//<span style="font-family: Arial, Helvetica, sans-serif;">sender.setMessage("你的163邮箱账号", "EmailS//ender", "Java Mail ！");这里面两个邮箱账号要一致</span>

        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void createOTP(){
        if(this.checkbalance()) {
            make_toast("已寄送驗證碼到您的信箱!");
            otp.create_password();
        }else{
            make_toast("餘額不足!");
        }
    }
    public void createOTP_Payment(){
        if(checkbalance_payment()) {
            make_toast("已寄送驗證碼到您的信箱!");
            otp.create_password();
        }else{
            make_toast("餘額不足!");
        }
    }

    public void checkReceiverAcc(String rAcc){
        control = new CheckAccExist(this);
        dbMgr.isexist_acc(rAcc);
    }

    public void checkOTP(String enterOTP){
        otp.check_otp(enterOTP);
    }
    public void checkOTP_payment(String enterOTP){
        otp.check_otp_payment(enterOTP);
    }
    public void transfer(){
        int money = Integer.parseInt(transfer_GUI.getMoney());
        String receiver = transfer_GUI.getAcc();

        user.transfer(money);
        dbMgr.update_recevier(receiver,money);
        dbMgr.update_balance(user.getAcc(),user.getBalance());
        dbMgr.insert_record(user.getAcc(),receiver,transfer_GUI.getMoney());
        make_toast("轉帳完成!!");
        show_menu_GUI();
        //dbMgr.insert_record(user.getAcc(),receiver,transfer_GUI.getMoney());
    }
    public void payment(){
        user.transfer(item.get_item_money());
        dbMgr.update_balance(user.getAcc(),user.getBalance());
        dbMgr.insert_record(user.getAcc(),item.get_item_name(),String.valueOf(item.get_item_money()));
        make_toast("感謝您的購買!!");
        show_menu_GUI();
    }
    public void setIteminfo(String item_name,int item_money){
        item=new Item();
        item.setItem_info(item_name,item_money);
    }

    public String showInfo(){
        return("帳號:"+user.getAcc()+"\n姓名:"+user.getName()+"\nE-mail:"+user.getEmail()+"\n餘額:"+user.getBalance());
    }
    public void setList(ArrayList<String> record) {
        this.list = record;
        Log.e("SetRecord",list.toString());

    }
    public ArrayList<String> getR(){
        Log.e("333",list.toString());
        return list;
    }
    public ArrayAdapter getAdapter(){
        ArrayAdapter adapter = new ArrayAdapter(mainActivity, android.R.layout.simple_list_item_1,getR());
        return adapter;
    }
    public boolean checkbalance(){
        return user.getBalance() > Integer.parseInt(transfer_GUI.getMoney());
    }
    public boolean checkbalance_payment(){
        return user.getBalance() > item.get_item_money();
    }
    public void db_load_finish(JSONObject db_result) {
        //  ProgressDialog_finish();
        control.process(db_result);
    }
    public void setSignup_GUI(signup signup_GUI) {
        this.sign = signup_GUI;
    }
    public void setMenu_GUI_GUI(menu menu_GUI) {
        this.menu_GUI = menu_GUI;
    }
    public void setDeposit_GUI(deposit deposit_GUI) {
        this.deposit_GUI = deposit_GUI;
    }
    public void setTransfer_GUI(Transfer transfer_GUI) {
        this.transfer_GUI = transfer_GUI;
    }
    public void setPurchase_GUI(Purchase purchase_GUI){
        this.purchase_GUI=purchase_GUI;
    }
    public void setPurchase_page_GUI(PurchasePage purchase_page_GUI){
        this.purchase_page_GUI=purchase_page_GUI;
    }
    public void setRecord_GUI(Record record_GUI){
        this.record_GUI=record_GUI;
    }
    public void setBmw_GUI(BMW bmw_GUI){
        this.bmw_GUI=bmw_GUI;
    }
    public void setDB_activity(Activity activity){
        dbMgr.setActivity(activity);
    }
    public void show_menu_GUI(){
        Intent intent = new Intent();
        intent.setClass(activity , menu.class);
        activity.startActivity(intent);
    }
    public void show_home_GUI(){
        Intent intent = new Intent();
        intent.setClass(sign , MainActivity.class);
        sign.startActivity(intent);
    }
    public void show_deposit_GUI(){
        Intent intent =  new Intent();
        intent.setClass(menu_GUI , deposit.class);
        menu_GUI.startActivity(intent);
    }
    public void show_transfer_GUI(){
        Intent intent = new Intent();
        intent.setClass(menu_GUI,Transfer.class);
        menu_GUI.startActivity(intent);
    }
    public void show_purchase_GUI(){
        Intent intent = new Intent();
        intent.setClass(activity,Purchase.class);
        menu_GUI.startActivity(intent);
    }
    public void show_purchase_page_GUI(Activity activity){
        Intent intent = new Intent();
        intent.setClass(activity,PurchasePage.class);
        activity.startActivity(intent);
    }
    public void show_record_GUI(){
        Intent intent = new Intent();
        intent.setClass(menu_GUI,Record.class);
        menu_GUI.startActivity(intent);
    }
    public void show_accinfo_GUI(){
        Intent intent = new Intent();
        intent.setClass(menu_GUI,AccInfo.class);
        menu_GUI.startActivity(intent);
    }
    public void show_robot_GUI(){
        Intent intent = new Intent();
        intent.setClass(menu_GUI, ChatActivity.class);
        menu_GUI.startActivity(intent);
    }
}
