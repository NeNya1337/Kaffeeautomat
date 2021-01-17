package com.nenya;

public class ActionNotFoundException extends Exception{
    public ActionNotFoundException(){
        super("This action doesn't exist.");
    }
    public ActionNotFoundException(String msg){
        super(msg);
    }
}
