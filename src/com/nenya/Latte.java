package com.nenya;

public class Latte  extends Coffee{
    private final int milk;
    public Latte(int index, String name, int water, int milk, int beans){
        super(index, name, water, beans);
        this.milk = milk;
    }
    public void showDrink(){
        super.showDrink();
        System.out.print("It adds " + getMilk() + " ml milk. ");
    }
    public int getMilk(){
        return this.milk;
    }
    public String validate(int milk, int beans, int water){
        String missing = "";
        missing += super.validate(beans, water);
        if(milk < this.getMilk()) missing += "milk,";
        return missing;
    }
}
