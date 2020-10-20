package com.example.satw;

public class User {
    private User(){}
    private static User user = new User();
    private String name;
    private String email;
    private String acc;
    private int balance;
    private Controller controller=Controller.getInstance();
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public  void setAcc(String acc){
        this.acc=acc;
    }
    public String getName(){
        return name;
    }
    public String getAcc(){
        return acc;
    }
    public String getEmail(){
        return email;
    }
    public int getBalance(){
        return balance;
    }
    public static User getInstance(){
        return user;
    }
    public void deposit(int money){
        balance+=money;
    }
    public void transfer(int money){
        balance-=money;
    }
}
