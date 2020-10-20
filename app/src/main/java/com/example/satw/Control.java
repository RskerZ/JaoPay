package com.example.satw;

import org.json.JSONObject;

abstract public class Control {
    protected Controller controller;
    public Control(Controller controller){
        this.controller=controller;
    }
    abstract protected void process(JSONObject result);
}
