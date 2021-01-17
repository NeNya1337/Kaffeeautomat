package com.nenya;

public class Coffee extends Drink{
    private final int beans;
    public Coffee(int index, String name, int water, int beans){
        super(index, name, water);
        this.beans = beans;
    }
    public void showDrink(){
        super.showDrink();
        System.out.print("It uses " + getBeans() + " beans.");
    }
    public int getBeans(){
        return this.beans;
    }
    public String validate(int beans, int water){
        String missing = "";
        missing += super.validate(water);
        if(beans < this.getBeans()) missing += "beans";
        return missing;
    }
}