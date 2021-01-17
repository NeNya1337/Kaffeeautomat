package com.nenya;

public class Latte  extends Drink{
    private final int beans;
    private final int milk;
    public Latte(int index, String name, int water, int milk, int beans){
        super(index, name, water);
        this.milk = milk;
        this.beans = beans;
    }
    public void showDrink(){
        super.showDrink();
        System.out.print("It adds " + getMilk() + " ml milk. ");
        System.out.println("It uses " + getBeans() + " beans.");
    }
    public int getBeans(){
        return this.beans;
    }

    public int getMilk(){
        return this.milk;
    }
}
