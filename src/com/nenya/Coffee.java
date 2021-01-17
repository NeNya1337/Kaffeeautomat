package com.nenya;

public class Coffee extends Drink{
    private final int beans;
    public Coffee(int index, String name, int water, int beans){
        super(index, name, water);
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