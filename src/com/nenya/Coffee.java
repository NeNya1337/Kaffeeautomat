package com.nenya;

public class Coffee extends Drink{
    private final int beans;
    public Coffee(String name, int water, int beans){
        super(name, water);
        this.beans = beans;
    }
    public void showDrink(){
        super.showDrink();
        System.out.println("It uses " + getBeans() + " beans.");
    }
    public int getBeans(){
        return this.beans;
    }
}