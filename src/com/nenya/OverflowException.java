package com.nenya;

public class OverflowException extends Exception{
    public OverflowException(){
        super("I am your OverflowException!");
    }
    public OverflowException(String msg){
        super(msg);
    }
}